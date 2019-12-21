package com.jd.intelligent.rule.ruleformat;

import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.rule.formater.FormaterUtils;

import java.util.List;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/20 23:00.
 */
public class MethodRuleFormater implements IRuleFormater{
    @Override
    public void format(List<Translation> words) {
        FormaterUtils.formatMethod(words);
    }
}
