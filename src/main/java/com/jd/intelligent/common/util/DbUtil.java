package com.jd.intelligent.common.util;

import java.sql.*;

/**
 * Created by sunxuedong1 on 2019/12/16.
 */
public class DbUtil {
    static Connection conn = null;
    static PreparedStatement pst = null;
    static {
        try {
            Class.forName(PropertyUtil.getPropertyValue("db.driverClassName"));//指定连接类型
            conn = DriverManager.getConnection(PropertyUtil.getPropertyValue("db.url"), PropertyUtil.getPropertyValue("db.username"), PropertyUtil.getPropertyValue("db.password"));//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ResultSet select(String sql){
        ResultSet resultSet= null;
        try {
            pst = conn.prepareStatement(sql);//准备执行语句
            resultSet = pst.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }
    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static String createSelectBySourceSql(String chinese){
        StringBuffer sb = new StringBuffer("SELECT * FROM source ");
        sb.append(" WHERE ").append("source_chinese = '").append(chinese).append("';");

        return sb.toString();
    }

    public static String createCountBySourceSql(String chinese){
        StringBuffer sb = new StringBuffer("SELECT COUNT(1) FROM source ");
        sb.append(" WHERE ").append("source_chinese = '").append(chinese).append("';");

        return sb.toString();
    }

    public static String createSelectLikeSourceSql(String chinese){
        StringBuffer sb = new StringBuffer("SELECT * FROM source ");
        sb.append(" WHERE ").append("source_chinese LIKE '%").append(chinese).append("%';");

        return sb.toString();
    }

    public static String createInsertSourceSql(String chinese){
        StringBuffer sb = new StringBuffer("INSERT INTO source (source_chinese, hot_weight) ");
        sb.append(" VALUES('").append(chinese).append("',1);");

        return sb.toString();
    }
    public static String createIncreaseHotWeightByIdSql(Long id){
        StringBuffer sb = new StringBuffer("UPDATE source SET hot_weight = hot_weight+1");
        sb.append(" WHERE id = ").append(id).append(";");

        return sb.toString();
    }

    public static String cereateCountTranslationSql(Long sourceId, Integer translationProperties, String translationResult){
        StringBuffer sb = new StringBuffer("SELECT COUNT(1) FROM translation ");
        sb.append(" WHERE source_id = ").append(sourceId)
                .append(" AND translation_properties = ").append(translationProperties)
                .append(" AND translation_result = ").append("'").append(translationResult).append("';");

        return sb.toString();
    }

    public static String createInsertTranslationSql(Long sourceId, Integer translationProperties, String translationResult){
        StringBuffer sb = new StringBuffer("INSERT INTO translation (source_id, translation_properties, translation_result, correct_weight) ");
        sb.append(" VALUES('").append(sourceId)
                .append(translationProperties).append(",")
                .append("'").append(translationResult).append("',")
                .append("',1);");

        return sb.toString();
    }

    public static String createIncreaseCorrectWeightByIdSql(Long id){
        StringBuffer sb = new StringBuffer("UPDATE translation SET correct_weight = correct_weight+1");
        sb.append(" WHERE id = ").append(id).append(";");

        return sb.toString();
    }

    //增加月份，是否可以大概率猜测哪个行业比较火
}
