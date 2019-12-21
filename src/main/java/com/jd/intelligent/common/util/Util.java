package com.jd.intelligent.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunxuedong1 on 2019/12/21.
 */
public class Util {

    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
