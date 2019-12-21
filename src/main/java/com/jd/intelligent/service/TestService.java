package com.jd.intelligent.service;


import com.alibaba.fastjson.JSON;
import com.jd.intelligent.api.NamingHandler;
import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.beans.TranslationResult;
import com.jd.intelligent.common.util.DbUtil;
import com.jd.intelligent.enums.OptionEnum;
import com.jd.intelligent.enums.TypeEnum;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunxuedong1 on 2019/12/13.
 */

public class TestService {

    public static void main(String args[]){
        NamingHandler namingHandler = new NamingHandler();
        NamingRequest request = new NamingRequest();
        request.setChineseWord("学生");
        request.setOption(OptionEnum.UPDATE);
        request.setType(TypeEnum.VARIABLE);
        Translation persistentWord = new Translation();
        persistentWord.setWord("student");
        request.setPersistentWord(persistentWord);
        TranslationResult result = namingHandler.translate(request);

            System.out.println(JSON.toJSON(result));

    }
}
