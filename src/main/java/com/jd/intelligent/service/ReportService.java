package com.jd.intelligent.service;

import com.jd.intelligent.beans.Report;

import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
public interface ReportService {
    List<Report> findTop100WordsHotAndCorrectWeight();
}
