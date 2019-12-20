package com.jd.intelligent.analyzer;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;

import java.util.List;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public abstract  class AbstractAnalyzer implements Analyzer{
    NamingRequest request;
    public AbstractAnalyzer(NamingRequest request){
         this.request = request;
    }

    @Override
    public List<Translation> analysis() {
        List<Translation>  result = doAnalysise(getTranslations());
        result.sort((Translation item1,Translation item2)->{
            return item1.getLikeNum()-item2.getLikeNum();
        });
        return  result;
    }

    private List<Translation> getTranslations(){
        return null;
    }

    abstract List<Translation> doAnalysise(List<Translation> willTranslations);
}
