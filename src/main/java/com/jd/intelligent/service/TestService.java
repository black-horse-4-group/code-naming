package com.jd.intelligent.service;


import com.jd.intelligent.api.NamingHandler;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.api.NamingHandler;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.beans.TranslationResult;
import com.jd.intelligent.beans.TranslationResult;
import com.jd.intelligent.common.util.DbUtil;
import com.jd.intelligent.enums.TypeEnum;
import com.jd.intelligent.enums.OptionEnum;
import com.jd.intelligent.enums.TypeEnum;

import java.sql.ResultSet;

/**
 * Created by sunxuedong1 on 2019/12/13.
 */

public class TestService {

    public static void main(String args[]){
//        try {
//            ResultSet set = DbUtil.select("select * from translation");
//            while (set.next()) {
//                 System.out.println(set.getString("translation_result"));
//            }
//        }catch(Exception e){
//
//        }



        NamingRequest request = new NamingRequest();
        request.setChineseWord("测试");
        request.setType(TypeEnum.CLASS);
        Translation translation = new Translation();
        translation.setWord("test_2222");
        request.setPersistentWord(translation);

        TranslationService translationService = new TranslationServiceImpl();
        translationService.persistenceTranslation(request);



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
