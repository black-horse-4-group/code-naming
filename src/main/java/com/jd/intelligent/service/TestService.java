package com.jd.intelligent.service;


import com.jd.intelligent.api.NamingHandler;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.beans.TranslationResult;
import com.jd.intelligent.common.util.DbUtil;
import com.jd.intelligent.enums.OptionEnum;
import com.jd.intelligent.enums.TypeEnum;

import java.sql.ResultSet;

/**
 * Created by sunxuedong1 on 2019/12/13.
 */

public class TestService {

    public static void main(String args[]){
        NamingHandler namingHandler = new NamingHandler();
        NamingRequest request = new NamingRequest();
        request.setChineseWord("safdsad");
        request.setOption(OptionEnum.QUERY);
        request.setType(TypeEnum.INTERFACE);
        TranslationResult result = namingHandler.translate(request);
        for(Translation translation : result.getTranslations()){
            System.out.println(translation.getWord());
        }

    }
}
