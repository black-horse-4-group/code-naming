package com.jd.intelligent.service;

import com.jd.intelligent.beans.Translation;

import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public interface TranslationService {

    /**
     * 获取翻译结果
     * @param word 输入的数据
     * @return 翻译结果
     */
    List<Translation> getTranslationResult(String word);

    /**
     * 持久化resource & translation,增加热度和准确度
     * @param word 输入的数据
     * @param translationResult 翻译结果
     */
    void persistenceTranslation(String word, String translationResult);
}
