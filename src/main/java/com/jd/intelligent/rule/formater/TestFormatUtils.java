package com.jd.intelligent.rule.formater;

import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.enums.TypeEnum;
import com.jd.intelligent.rule.factory.RuleFormatFactory;
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
        testRuleFormat();
    }

    public static void testRuleFormat(){
        List<Translation> words = new ArrayList<>();
        Translation word1 = new Translation();
        word1.setWord("eat_food");
        word1.setFrom(0);

        Translation word2 = new Translation();
        word2.setWord("drink_milk");
        word2.setFrom(1);
        Translation word3 = new Translation();
        word3.setWord("drink_milk");
        word3.setFrom(1);

        words.add(word1);
        words.add(word2);
        words.add(word3);

        List<Translation> words2 = new ArrayList<>();
        Translation word12 = new Translation();
        word12.setWord("eat_food");
        word12.setFrom(0);

        Translation word22 = new Translation();
        word22.setWord("drink_milk");
        word22.setFrom(1);
        Translation word32 = new Translation();
        word32.setWord("drink_milk");
        word32.setFrom(1);

        words2.add(word12);
        words2.add(word22);
        words2.add(word32);


        List<Translation> classList = new RuleFormatFactory(words, TypeEnum.CLASS).format();
        List<Translation> constantList = new RuleFormatFactory(words2, TypeEnum.CONSTANT).format();
//        List<Translation> enumList = new RuleFormatFactory(words, TypeEnum.ENUM).format();
//        List<Translation> interfaceList = new RuleFormatFactory(words2, TypeEnum.INTERFACE).format();
//        List<Translation> methodList = new RuleFormatFactory(words, TypeEnum.METHOD).format();
//        List<Translation> packageList = new RuleFormatFactory(words2, TypeEnum.PACKAGE).format();
//        List<Translation> subClassList = new RuleFormatFactory(words, TypeEnum.SUB_CLASS).format();
//        List<Translation> variableList = new RuleFormatFactory(words2, TypeEnum.VARIABLE).format();

        System.out.println(words);
    }
}
