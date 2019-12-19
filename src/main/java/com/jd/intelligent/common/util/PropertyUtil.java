package com.jd.intelligent.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sunxuedong1 on 2019/12/16.
 */
public class PropertyUtil {
    static Properties properties;
    static{
        properties = new Properties();
        InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return properties.getProperty(key);
    }
}
