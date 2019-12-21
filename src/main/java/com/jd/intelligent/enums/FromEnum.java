package com.jd.intelligent.enums;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public enum FromEnum {
    DB(1, "数据库"),
    YOU_DAO(2, "有道接口");

    private int code;
    private String desc;

    FromEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
