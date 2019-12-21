package com.jd.intelligent.service;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;
import com.jd.intelligent.enums.TypeEnum;

import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public class TranslationServiceImpl implements TranslationService {
    @Override
    public List<Translation> getTranslationResult(String word, TypeEnum typeEnum) {
        return null;
    }

    @Override
    public void persistenceTranslation(NamingRequest namingRequest) {

    }
}
