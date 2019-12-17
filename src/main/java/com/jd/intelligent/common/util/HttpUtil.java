package com.jd.intelligent.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by sunxuedong1 on 2019/12/16.
 */
public class HttpUtil {
    public static String doGet(String url){
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);           //创建HttpGet
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();            //获取响应实体
            if (null != entity) {
                String responseContent = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity); //Consume response content
                return responseContent;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }



}
