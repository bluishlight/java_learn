package com.atguigu3.preparedStatement;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.aituigu3.util.JDBCUtils;
public class PreparedStatementReview {
    public static void main(String[] args) {
        String propertiesStr = "jdbc2.properties";
        Connection conn = null;
        PreparedStatement ps = null;
        //1 建立链接
        try {
            conn = JDBCUtils.getConnection(propertiesStr);
            System.out.println(conn);
            // 创建Statement sql
//            String sql = "INSERT into customers(name,email,birth) values(?,?,?)";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, "北斗");
//            ps.setString(2, "hh.email");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date date = sdf.parse("2022-11-29");
//            ps.setDate(3, new Date(date.getTime()));
            String sql="update customers set name = ?, email = ? where id = ?";
            JDBCUtils.commonUpdate(conn, ps, sql,  "北斗", "beidou.email", "22");


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(conn,ps);
        }

    }
}
