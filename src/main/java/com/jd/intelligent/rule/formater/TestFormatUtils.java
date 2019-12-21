package com.jd.intelligent.rule.formater;

import com.jd.intelligent.beans.Translation;
import jdk.nashorn.internal.parser.JSONParser;

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
        List<Translation> words = new ArrayList<>();
        Translation word1 = new Translation();
        word1.setWord("eat_food");

        Translation word2 = new Translation();
        word2.setWord("drink_milk");

        words.add(word1);
        words.add(word2);

        System.out.println(FormaterUtils.formatClass(words));
    }
}
