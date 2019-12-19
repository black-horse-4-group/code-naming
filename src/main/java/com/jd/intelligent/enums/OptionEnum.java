package com.jd.intelligent.enums;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public enum  OptionEnum {
    QUERY(0,"查询"),
    UPDATE(1,"更新");

    /**类型码*/
    private int type;
    /**类型值*/
    private String value;

    OptionEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }
}
