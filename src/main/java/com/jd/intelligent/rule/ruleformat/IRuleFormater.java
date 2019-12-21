package com.jd.intelligent.rule.ruleformat;

import com.jd.intelligent.beans.Translation;

import java.util.List;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/20 22:49.
 */
public interface IRuleFormater {

    void format(List<Translation> words);
}
