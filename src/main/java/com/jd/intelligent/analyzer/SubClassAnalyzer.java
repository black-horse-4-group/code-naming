package com.jd.intelligent.analyzer;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.constant.Constant;
import com.jd.intelligent.enums.FromEnum;

import java.util.List;

/**
 * Created by sunxuedong1 on 2019/12/20.
 */
public class SubClassAnalyzer extends AbstractAnalyzer{
    public SubClassAnalyzer(NamingRequest request){
        super(request);
    }
    @Override
    List<Translation> doAnalysise(List<Translation> willTranslations) {
        if(willTranslations!=null && willTranslations.size()>0){
            willTranslations.stream().forEach((item)->{
                if(item.getFrom()==   FromEnum.YOU_DAO.getCode()){
                    item.setWord(item.getWord()+ Constant.SLIP_CHAR+"impl");
                }
            });
        }
        return willTranslations;
    }
}
