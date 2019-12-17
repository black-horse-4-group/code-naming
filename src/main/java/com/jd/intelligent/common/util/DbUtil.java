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
}
