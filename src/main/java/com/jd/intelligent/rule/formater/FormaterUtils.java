package com.jd.intelligent.rule.formater;

import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.constant.Constant;
import com.jd.intelligent.constant.FromConstant;
import com.jd.intelligent.enums.FromEnum;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author wangshuai
 * @Description
 * @date 2019/12/21 9:47.
 */
public class FormaterUtils {

    public static void formatClass(List<Translation> words){
        if(CollectionUtils.isEmpty(words)){
            return;
        }
        words.stream().forEach(e->{
            if(e.getFrom() == FromEnum.DB.getCode()){
                return;
            }
            String[] wordSpliteArr = e.getWord().split(Constant.SLIP_CHAR);
            StringBuilder sb = new StringBuilder();
            Arrays.asList(wordSpliteArr).stream()
                    .filter(Objects::nonNull)
                    .forEach(f->{
                        String first = f.substring(0,1).toUpperCase();
                        String others = f.substring(1);
                        sb.append(first);
                        sb.append(others);
                    });
            e.setWord( sb.toString());
        });
    }

    public static void formatConstant(List<Translation> words){
        if(CollectionUtils.isEmpty(words)){
            return;
        }
        words.stream().forEach(e->{
            if(e.getFrom() == FromEnum.DB.getCode()){
                return;
            }
            String[] wordSpliteArr = e.getWord().split(Constant.SLIP_CHAR);
            StringBuilder sb = new StringBuilder();
            Arrays.asList(wordSpliteArr).stream()
                    .filter(Objects::nonNull)
                    .forEach(f->{
                        sb.append(f.toUpperCase());
                        sb.append("_");
                    });
            e.setWord( sb.toString().substring(0,sb.length()-1));
        });
    }

    public static void formatMethod(List<Translation> words){
        if(CollectionUtils.isEmpty(words)){
            return;
        }
        words.stream().forEach(e->{
            if(e.getFrom() == FromEnum.DB.getCode()){
                return;
            }
            String[] wordSpliteArr = e.getWord().split(Constant.SLIP_CHAR);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<wordSpliteArr.length;i++){
                String value = wordSpliteArr[i];
                if(i == 0){
                    sb.append(value);
                }else{
                    String first = value.substring(0,1).toUpperCase();
                    String others = value.substring(1);

                    sb.append(first);
                    sb.append(others);
                }
            }
            e.setWord(sb.toString());
        });
    }

    public static void formatPackage(List<Translation> words){
        if(CollectionUtils.isEmpty(words)){
            return;
        }
        words.stream().forEach(e->{
            if(e.getFrom() == FromEnum.DB.getCode()){
                return;
            }
            String[] wordSpliteArr = e.getWord().split(Constant.SLIP_CHAR);
            StringBuilder sb = new StringBuilder();
            Arrays.asList(wordSpliteArr).stream()
                    .filter(Objects::nonNull)
                    .forEach(f->sb.append(f.toLowerCase()));
            e.setWord(sb.toString());
        });
    }
}
