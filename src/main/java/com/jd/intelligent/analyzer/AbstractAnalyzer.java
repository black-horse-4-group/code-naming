package com.jd.intelligent.analyzer;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.constant.Constant;
import com.jd.intelligent.service.TranslationService;
import com.jd.intelligent.service.TranslationServiceImpl;

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
        List<Translation> translations = preProcessing();
        List<Translation>  result = doAnalysise(translations);
        return  result;
    }

    private List<Translation> preProcessing(){
        List<Translation> result = getTranslations();
        if(result!=null && result.size()>0){
            result.stream().forEach((translation)->{
                translation.setWord(translation.getWord().replaceAll(" ", Constant.SLIP_CHAR));
            });
        }
       return result;
    }

    private List<Translation> getTranslations(){
        TranslationService translationService = new TranslationServiceImpl();
        return translationService.getTranslationResult(request.getChineseWord(),request.getType());
    }

    abstract List<Translation> doAnalysise(List<Translation> willTranslations);
}
