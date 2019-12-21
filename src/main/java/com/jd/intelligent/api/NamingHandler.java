package com.jd.intelligent.api;

import com.jd.intelligent.analyzer.AnalyzerFactory;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.beans.TranslationResult;
import com.jd.intelligent.common.util.Util;
import com.jd.intelligent.enums.OptionEnum;
import com.jd.intelligent.rule.factory.RuleFormatFactory;
import com.jd.intelligent.service.TranslationService;
import com.jd.intelligent.service.TranslationServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public class NamingHandler {

    public TranslationResult translate(NamingRequest request){
        TranslationResult result = new TranslationResult();
        try {
            result.setSuccess(true);
            List<Translation> translations = null;
            if (request.getOption() == OptionEnum.QUERY) {
                translations = AnalyzerFactory.createAnalyzer(request).analysis();
            } else {
                if (StringUtils.isNotBlank(request.getChineseWord()) && !Util.isContainChinese(request.getChineseWord())) {
                    TranslationService translationService = new TranslationServiceImpl();
                    translationService.persistenceTranslation(request);
                }
            }
            RuleFormatFactory ruleFormatFactory = new RuleFormatFactory(translations, request.getType());
            List<Translation> afterRuleTranslations = ruleFormatFactory.format();
            if(afterRuleTranslations!=null && afterRuleTranslations.size()>10){
                afterRuleTranslations = afterRuleTranslations.subList(0,10);
            }
           result.setTranslations(afterRuleTranslations == null ? new ArrayList<Translation>() : afterRuleTranslations);
        }catch(Exception e){
            result.setSuccess(false);
            System.err.println(e);
        }
        return result;
    }
}
