package com.jd.intelligent.beans;

import com.jd.intelligent.enums.OptionEnum;
import com.jd.intelligent.enums.TypeEnum;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public class NamingRequest {
    private String chineseWord;

    private TypeEnum type;

    private OptionEnum option;

    private Translation persistentWord;

    public String getChineseWord() {
        return chineseWord;
    }

    public void setChineseWord(String chineseWord) {
        this.chineseWord = chineseWord;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public OptionEnum getOption() {
        return option;
    }

    public void setOption(OptionEnum option) {
        this.option = option;
    }

    public Translation getPersistentWord() {
        return persistentWord;
    }

    public void setPersistentWord(Translation persistentWord) {
        this.persistentWord = persistentWord;
    }
}
