package com.jd.intelligent.beans;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public class Report {
    private String wordWithTranslation;
    private Long hotWeight;
    private Long correctWeight;

    public String getWordWithTranslation() {
        return wordWithTranslation;
    }

    public void setWordWithTranslation(String wordWithTranslation) {
        this.wordWithTranslation = wordWithTranslation;
    }

    public Long getHotWeight() {
        return hotWeight;
    }

    public void setHotWeight(Long hotWeight) {
        this.hotWeight = hotWeight;
    }

    public Long getCorrectWeight() {
        return correctWeight;
    }

    public void setCorrectWeight(Long correctWeight) {
        this.correctWeight = correctWeight;
    }

    @Override
    public String toString() {
        return "Report{" +
                "wordWithTranslation='" + wordWithTranslation + '\'' +
                ", hotWeight=" + hotWeight +
                ", correctWeight=" + correctWeight +
                '}';
    }
}
