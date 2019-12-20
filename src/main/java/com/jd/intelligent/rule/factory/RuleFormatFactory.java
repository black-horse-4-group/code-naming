package com.jd.intelligent.rule.factory;

import com.jd.intelligent.enums.TypeEnum;
import com.jd.intelligent.rule.ruleformat.*;

import java.util.List;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/20 22:37.
 */
public class RuleFormatFactory {

    private String context;
    private List<String> words;
    private TypeEnum type;

    public RuleFormatFactory(String context,List<String> words,TypeEnum type){
        this.context = context;
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
                return getFormaterByContext();
        }
    }

    private IRuleFormater getFormaterByContext(){
        if(context.contains("static") && context.contains("final")){
            return new ConstantRuleFormater();
        }
        return new VariableRuleFormater();
    }


    public String format(){
        return getFormater().format(words);
    }
}
