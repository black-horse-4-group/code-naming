package com.jd.intelligent.enums;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public enum TypeEnum {
    CLASS(0,"类"),
    INTERFACE(1,"接口"),
    METHOD(2,"方法"),
    ENUM(3,"枚举"),
    SUB_CLASS(4,"子类");

    /**类型码*/
    private int type;
    /**类型值*/
    private String value;

    TypeEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }

}
