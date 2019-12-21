package com.jd.intelligent.rule.formater;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/21 10:42.
 */
public class TestFormatUtils {

    public static void main(String[] args) {
        testClassFormatUtils();
    }

    public static void testClassFormatUtils(){
        List<String> words = new ArrayList<>();
        words.add("eat_food");
        words.add("drink_milk");

        System.out.println(FormaterUtils.formatClass(words));
    }
}
