package com.jd.intelligent.api;

import com.jd.intelligent.analyzer.AnalyzerFactory;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.beans.TranslationResult;
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
        List<Translation> translations = AnalyzerFactory.createAnalyzer(request).analysis();
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
