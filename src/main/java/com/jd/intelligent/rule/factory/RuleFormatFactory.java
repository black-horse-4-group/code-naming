package com.jd.intelligent.rule.factory;

import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.enums.TypeEnum;
import com.jd.intelligent.rule.ruleformat.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/20 22:37.
 */
public class RuleFormatFactory {

    private List<Translation> words;
    private TypeEnum type;

    public RuleFormatFactory(List<Translation> words,TypeEnum type){
        this.words = words;
        this.type = type;
    }

    private IRuleFormater getFormater(){
        switch(type){
            case CLASS:
                return new ClassRuleFormater();
            case SUB_CLASS:
                return new SubClassRuleFormater();
            case PACKAGE:
                return new PackageRuleFormater();
            case CONSTANT:
                return new ConstantRuleFormater();
            case ENUM:
                return new EnumRuleFormater();
            case INTERFACE:
                return new InterfaceRuleFormater();
            case METHOD:
                return new MethodRuleFormater();
            case VARIABLE:
                return new VariableRuleFormater();
            default:
                return new VariableRuleFormater();
        }
    }

    private void distinct(){
        List<Translation> result = new ArrayList<>();
        if(CollectionUtils.isEmpty(words)){
            return;
        }
        Map<String,List<Translation>> resultMap =words.stream()
             .collect(Collectors.groupingBy(Translation::getWord));
        resultMap.keySet().stream()
                .forEach(e->{
                    List<Translation> resultList = resultMap.get(e);
                    if(CollectionUtils.isNotEmpty(resultList)){
                        resultList.sort((Translation item1, Translation item2) -> {
                            return  item2.getLikeNum() - item1.getLikeNum();
                        });
                        result.add(resultList.get(0));
                    }
                });
        words = result;
    }

    public List<Translation> format(){
        if(CollectionUtils.isEmpty(words)){
            return Collections.EMPTY_LIST;
        }
        getFormater().format(words);
        distinct();
        if(words!=null) {
            words.sort((Translation item1, Translation item2) -> {
                return  item2.getLikeNum() - item1.getLikeNum();
            });
        }
        return words;
    }
}
