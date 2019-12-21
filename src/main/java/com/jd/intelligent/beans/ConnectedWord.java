package com.jd.intelligent.beans;

import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public class ConnectedWord {
    private List<String> value;
    private String key;

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ConnectedWord{" +
                "value=" + value +
                ", key='" + key + '\'' +
                '}';
    }
}
