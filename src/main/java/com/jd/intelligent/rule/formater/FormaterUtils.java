package com.jd.intelligent.rule.formater;

import com.jd.intelligent.constant.Constant;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/21 9:47.
 */
public class FormaterUtils {

    public static List<String> formatClass(List<String> words){
        if(CollectionUtils.isEmpty(words)){
            return Collections.EMPTY_LIST;
        }
        return words.stream().map(e->{
            String[] wordSpliteArr = e.split(Constant.SLIP_CHAR);
            StringBuilder sb = new StringBuilder();
            Arrays.asList(wordSpliteArr).stream().forEach(f->{
                String first = f.substring(0,1).toUpperCase();
                String others = f.substring(1);
                sb.append(first);
                sb.append(others);
            });
            return sb.toString();
        }).collect(Collectors.toList());
    }
}
