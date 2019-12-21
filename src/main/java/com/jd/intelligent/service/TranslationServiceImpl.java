package com.jd.intelligent.service;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.common.util.DbUtil;
import com.jd.intelligent.enums.TypeEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public class TranslationServiceImpl implements TranslationService {
    @Override
    public List<Translation> getTranslationResult(String word, TypeEnum typeEnum) {








        return null;
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
                Long sourceId = getResourceId(namingRequest);
                dealTranslation(sourceId, namingRequest);
                return;
            }
            
            //update an exists line
            System.out.println("update an exists line");
            Long sourceId = getResourceId(namingRequest);
            String increaseSourceHotWeight = DbUtil.createIncreaseHotWeightByIdSql(sourceId);
            System.out.println(increaseSourceHotWeight);
            DbUtil.update(increaseSourceHotWeight);
            dealTranslation(sourceId, namingRequest);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    private Long getResourceId(NamingRequest namingRequest) throws SQLException {
        ResultSet source = DbUtil.select(DbUtil.createSelectBySourceSql(namingRequest.getChineseWord()));
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
