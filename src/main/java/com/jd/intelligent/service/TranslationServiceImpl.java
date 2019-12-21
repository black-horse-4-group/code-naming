package com.jd.intelligent.service;

import com.alibaba.fastjson.JSONObject;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.beans.YouDaoResultBean;
import com.jd.intelligent.common.util.DbUtil;
import com.jd.intelligent.common.util.HttpUtil;
import com.jd.intelligent.common.util.PropertyUtil;
import com.jd.intelligent.enums.FromEnum;
import com.jd.intelligent.enums.TypeEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public class TranslationServiceImpl implements TranslationService {
    @Override
    public List<Translation> getTranslationResult(String word, TypeEnum typeEnum) {
        String youDaoResultStr;
        try{
            youDaoResultStr = getFromYouDao(word);
            if(StringUtils.isBlank(youDaoResultStr)){
                return getFromDb(word, typeEnum);
            }
        }catch (Exception e){
            System.err.println(e);
            return getFromDb(word, typeEnum);
        }
        YouDaoResultBean resultBean = JSONObject.parseObject(youDaoResultStr, YouDaoResultBean.class);
        List<Translation> dbResult = getFromDb(word, typeEnum);

        return formatYouDaoWithDb(resultBean, dbResult);
    }

    private List<Translation> formatYouDaoWithDb(YouDaoResultBean resultBean, List<Translation> dbResult) {
        List<Translation> translations = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(resultBean.getTranslation())){
            resultBean.getTranslation().forEach(e -> initYouDaoTranslation(translations, e));
        }
        if(CollectionUtils.isNotEmpty(resultBean.getWeb())){
            resultBean.getWeb()
                    .forEach(e -> e.getValue()
                            .forEach(value -> initYouDaoTranslation(translations, value)));
        }
        if(CollectionUtils.isNotEmpty(dbResult)){
            translations.addAll(dbResult);
        }

        return translations;
    }

    private void initYouDaoTranslation(List<Translation> translations, String value) {
        Translation translation = new Translation();
        translation.setFrom(FromEnum.YOU_DAO.getCode());
        translation.setWord(value);
        translation.setLikeNum(0);
        translations.add(translation);
    }

    private List<Translation> getFromDb(String word, TypeEnum typeEnum) {
        try {
            Long sourceId = getResourceId(word);
            if(sourceId == null || sourceId == 0L){
                return new ArrayList<>();
            }

           String createSelectTranslationBySourceSql = DbUtil.createSelectTranslationBySourceSql(sourceId, typeEnum.getType());
            System.out.println(createSelectTranslationBySourceSql);
            ResultSet resultSet = DbUtil.select(createSelectTranslationBySourceSql);

            List<Translation> translations = new ArrayList<>();
            while(resultSet.next()){
                Translation translation = new Translation();
                translation.setWord(resultSet.getString("translation_result"));
                translation.setFrom(FromEnum.DB.getCode());
                translation.setLikeNum(resultSet.getInt("correct_weight"));

                translations.add(translation);
            }
            return translations;
        } catch (SQLException e) {
            throw new RuntimeException("DB:根据"+word+"和"+typeEnum+"获取数据异常");
        }
    }

    private String getFromYouDao(String word) {
        String youDaoUrl = PropertyUtil.getPropertyValue("youdao.url").concat(word);
        return HttpUtil.doGet(youDaoUrl);
    }

    @Override
    public void persistenceTranslation(NamingRequest namingRequest) {
        try {
            ResultSet resultSet = DbUtil.select(DbUtil.createCountBySourceSql(namingRequest.getChineseWord()));
            int count = getCount(resultSet);
            //insert a new line
            if(count < 1) {
                System.out.println("insert a new line");
                DbUtil.update(DbUtil.createInsertSourceSql(namingRequest.getChineseWord()));
                Long sourceId = getResourceId(namingRequest.getChineseWord());
                dealTranslation(sourceId, namingRequest);
                return;
            }
            
            //update an exists line
            System.out.println("update an exists line");
            Long sourceId = getResourceId(namingRequest.getChineseWord());
            String increaseSourceHotWeight = DbUtil.createIncreaseHotWeightByIdSql(sourceId);
            System.out.println(increaseSourceHotWeight);
            DbUtil.update(increaseSourceHotWeight);
            dealTranslation(sourceId, namingRequest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Long getResourceId(String word) throws SQLException {
        ResultSet source = DbUtil.select(DbUtil.createSelectBySourceSql(word));
        while(source.next()){
            return Long.valueOf(source.getString("id"));
        }
     return 0L;
    }

    private void dealTranslation(Long sourceId, NamingRequest namingRequest) throws SQLException {
        String translationResult = namingRequest.getPersistentWord().getWord();

        String countTranslationSql = DbUtil.cereateCountTranslationSql(sourceId, namingRequest.getType().getType(), translationResult);
        System.out.println(countTranslationSql);

        int translationCount = getCount(DbUtil.select(countTranslationSql));
        if(translationCount < 1){
            System.out.println("insert a new line 2 translation");
            insert2Translation(sourceId, namingRequest.getType().getType(), translationResult);
            return;
        }
        System.out.println("update an exists line in translation");
        cereateIncreaseTranslationWeightSql(sourceId, namingRequest.getType().getType(), translationResult);
    }

    private void cereateIncreaseTranslationWeightSql(Long sourceId, int type, String translationResult) {
        String increaseTranslationWeightSql = DbUtil.cereateIncreaseTranslationWeightSql(sourceId, type, translationResult);
        System.out.println(increaseTranslationWeightSql);
        DbUtil.update(increaseTranslationWeightSql);
    }

    private void insert2Translation(Long sourceId, int type, String translationResult) {
        String insertTranslationSql = DbUtil.createInsertTranslationSql(sourceId, type, translationResult);
        System.out.println(insertTranslationSql);
        DbUtil.update(insertTranslationSql);
    }

    private int getCount(ResultSet resultSet) throws SQLException {
        int count = 0;
        while(resultSet.next()){
            count = resultSet.getInt("count");
        }
        return count;
    }
}
