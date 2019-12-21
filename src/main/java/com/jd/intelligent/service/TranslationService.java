package com.jd.intelligent.service;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.enums.TypeEnum;

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
    List<Translation> getTranslationResult(String word, TypeEnum typeEnum);

    /**
     * 持久化resource & translation,增加热度和准确度
     * @param namingRequest 入参数据
     */
    void persistenceTranslation(NamingRequest namingRequest);
}
