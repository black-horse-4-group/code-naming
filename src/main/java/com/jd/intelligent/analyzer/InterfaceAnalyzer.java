package com.jd.intelligent.analyzer;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.beans.Translation;

import java.util.List;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public class InterfaceAnalyzer extends AbstractAnalyzer{
    public InterfaceAnalyzer(NamingRequest request){
        super(request);
    }
    @Override
    List<Translation> doAnalysise(List<Translation> willTranslations) {
        return willTranslations;
    }
}
