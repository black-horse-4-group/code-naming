package com.jd.intelligent.beans;

import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public class YouDaoResultBean {
    private String query;
    private int errorCode;
    private List<String> translation;
    private List<ConnectedWord> web;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<ConnectedWord> getWeb() {
        return web;
    }

    public void setWeb(List<ConnectedWord> web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "YouDaoResultBean{" +
                "query='" + query + '\'' +
                ", errorCode=" + errorCode +
                ", translation=" + translation +
                ", web=" + web +
                '}';
    }
}
