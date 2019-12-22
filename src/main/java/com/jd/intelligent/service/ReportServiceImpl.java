package com.jd.intelligent.service;

import com.jd.intelligent.beans.Report;
import com.jd.intelligent.common.util.DbUtil;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzheng.qiao on 2019/12/21.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public List<Report> findTop100WordsHotAndCorrectWeight() {
        String top100 = DbUtil.createTop100Source();

        List<Report> list = new ArrayList<>();
        try {
            ResultSet resultSet = DbUtil.select(top100);
            while(resultSet.next()){
                String tmpSql = DbUtil.createMostTranslationBySourceId(resultSet.getLong("id"));
                ResultSet tmpResult = DbUtil.select(tmpSql);
                while (tmpResult.next()){
                    Report report = new Report();
                    report.setWordWithTranslation(resultSet.getString("source_chinese")+":"+tmpResult.getString("translation_result"));
                    report.setHotWeight(resultSet.getLong("hot_weight"));
                    report.setCorrectWeight(tmpResult.getLong("correct_weight"));

                    list.add(report);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("获取报表数据异常");
        }

        return list;
    }
}
