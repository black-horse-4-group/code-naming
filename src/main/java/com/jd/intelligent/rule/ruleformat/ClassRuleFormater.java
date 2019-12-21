package com.jd.intelligent.rule.ruleformat;

import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.rule.formater.FormaterUtils;

import java.util.List;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/20 22:54.
 */
public class ClassRuleFormater implements IRuleFormater{
    @Override
    public List<Translation> format(List<Translation> words) {

        return FormaterUtils.formatClass(words);
    }
}
