package com.jd.intelligent.api;

import com.jd.intelligent.analyzer.AnalyzerFactory;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.beans.TranslationResult;
import com.jd.intelligent.constant.FromConstant;
import com.jd.intelligent.enums.OptionEnum;
import com.jd.intelligent.enums.TypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public class NamingHandler {

    public TranslationResult translate(NamingRequest request){
        TranslationResult result = new TranslationResult();
        result.setSuccess(true);
        if(request.getOption()==OptionEnum.QUERY){
            List<Translation> translations = AnalyzerFactory.createAnalyzer(request).analysis();
        }

        List<Translation> translations = new ArrayList<Translation>();
        Translation translation1 = new Translation();
        translation1.setWord("teacher");
        translation1.setLikeNum(2);
        translation1.setFrom(FromConstant.FROM_DB);
        translations.add(translation1);
        Translation translation2 = new Translation();
        translation2.setWord("student");
        translation2.setLikeNum(0);
        translation2.setFrom(FromConstant.FROM_YOUDAO);
        translations.add(translation2);
        result.setTranslations(translations);
        return result;
    }

    private List<Translation> getClassTranslations(){
        List<Translation> result = new ArrayList<Translation>();
        Translation translation = new Translation();
        translation.setWord("Student");
        result.add(translation);
        Translation translation2 = new Translation();
        translation2.setWord("Teacher");
        result.add(translation2);
        return result;
    }


    private List<Translation> getMethodTranslations(){
        List<Translation> result = new ArrayList<Translation>();
        Translation translation = new Translation();
        translation.setWord("doStudy");
        result.add(translation);
        Translation translation2 = new Translation();
        translation2.setWord("doWork");
        result.add(translation2);
        return result;
    }
}
