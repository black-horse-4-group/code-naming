package com.jd.intelligent.analyzer;

import com.jd.intelligent.beans.NamingRequest;
import com.jd.intelligent.enums.TypeEnum;

/**
 * Created by sunxuedong1 on 2019/12/19.
 */
public class AnalyzerFactory {
    public static Analyzer createAnalyzer(NamingRequest request){
        TypeEnum typeEnum = request.getType();
      switch (typeEnum){
          case CLASS:
              return  new ClassAnalyzer(request);
          case INTERFACE:
              return new InterfaceAnalyzer(request);
          case METHOD:
              return new MethodAnalyzer(request);
          case ENUM:
              return  new EnumAnalyzer(request);
          case SUB_CLASS:
              return new SubClassAnalyzer(request);
          default:
              return  new ClassAnalyzer(request);
      }
    }
}
