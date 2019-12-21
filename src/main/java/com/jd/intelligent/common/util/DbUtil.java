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
    public static boolean update(String sql){
        boolean resultSet= false;
        try {
            pst = conn.prepareStatement(sql);
            resultSet = pst.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }
    public static void close() {
        try {
            conn.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String createSelectBySourceSql(String chinese){
        StringBuffer sb = new StringBuffer("SELECT * FROM source ");
        sb.append(" WHERE").append(" binary source_chinese = '").append(chinese).append("';");

        return sb.toString();
    }

    public static String createCountBySourceSql(String chinese){
        StringBuffer sb = new StringBuffer("SELECT COUNT(1) count FROM source ");
        sb.append(" WHERE").append(" binary source_chinese = '").append(chinese).append("';");

        return sb.toString();
    }

    public static String createSelectLikeSourceSql(String chinese){
        StringBuffer sb = new StringBuffer("SELECT * FROM source ");
        sb.append(" WHERE").append(" source_chinese LIKE '%").append(chinese).append("%';");

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

    public static String cereateCountTranslationSql(Long sourceId, int type, String translationResult){
        StringBuffer sb = new StringBuffer("SELECT COUNT(1) count FROM translation ");
        sb.append(" WHERE source_id = ").append(sourceId)
                .append(" AND translation_type = ").append(type)
                .append(" AND binary translation_result = ").append("'").append(translationResult).append("';");

        return sb.toString();
    }

    public static String createInsertTranslationSql(Long sourceId, Integer type, String translationResult){
        StringBuffer sb = new StringBuffer("INSERT INTO translation (source_id, translation_type, translation_result, correct_weight) ");
        sb.append(" VALUES(").append(sourceId).append(",")
                .append(type).append(",")
                .append("'").append(translationResult).append("',")
                .append("1);");

        return sb.toString();
    }

    public static String createIncreaseCorrectWeightByIdSql(Long id){
        StringBuffer sb = new StringBuffer("UPDATE translation SET correct_weight = correct_weight+1");
        sb.append(" WHERE id = ").append(id).append(";");

        return sb.toString();
    }

    public static String cereateIncreaseTranslationWeightSql(Long sourceId, int type, String translationResult) {
        StringBuffer sb = new StringBuffer("UPDATE translation SET correct_weight = correct_weight+1");
        sb.append(" WHERE source_id = ").append(sourceId)
                .append(" AND translation_type = ").append(type)
                .append(" AND binary translation_result = ").append("'").append(translationResult).append("';");

        return sb.toString();
    }

    public static String createSelectTranslationBySourceSql(Long sourceId, int type){
        StringBuffer sb = new StringBuffer("SELECT * FROM translation ");
        sb.append(" WHERE").append(" source_id = ").append(sourceId)
                .append(" AND translation_type =").append(type)
                .append(" ORDER BY correct_weight DESC");

        return sb.toString();
    }

    //增加月份，是否可以大概率猜测哪个行业比较火
}
