package com.jd.intelligent.beans;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public class Translation {
    private String word;
    private int likeNum;//点赞数
    private int from;//来源  0：数据库   1：有道接口

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "word='" + word + '\'' +
                ", likeNum=" + likeNum +
                ", from=" + from +
                '}';
    }
}
