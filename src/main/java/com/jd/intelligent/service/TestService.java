package com.jd.intelligent.service;


import com.jd.intelligent.common.util.DbUtil;

import java.sql.ResultSet;

/**
 * Created by sunxuedong1 on 2019/12/13.
 */

public class TestService {

    public static void main(String args[]){
        try {
            ResultSet set = DbUtil.select("select * from translation");
            while (set.next()) {
                 System.out.println(set.getString("translation_result"));
            }
        }catch(Exception e){

        }
    }
}
