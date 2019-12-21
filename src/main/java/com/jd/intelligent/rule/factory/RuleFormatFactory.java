package com.jd.intelligent.rule.factory;

import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.enums.TypeEnum;
import com.jd.intelligent.rule.ruleformat.*;

import java.util.List;

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



    public List<Translation> format(){

        return getFormater().format(words);
    }
}
