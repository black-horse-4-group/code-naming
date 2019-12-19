package com.jd.intelligent.beans;

import java.util.List;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public class TranslationResult {
    private boolean success;
    private List<Translation> translations;
    private String errMsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
