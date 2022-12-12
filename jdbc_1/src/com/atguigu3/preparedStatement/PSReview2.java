package com.atguigu3.preparedStatement;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PSReview2 {
    public static void main(String[] args) {
        Connection conn =null;
        PreparedStatement ps = null;
        // 建立连接
        try {
            Properties properties = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc2.properties");
            properties.load(is);
            String user = properties.getProperty("user");
            String password  = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driver");
            Class clazz = (Class) Class.forName(driverClass);
            Driver driver = (Driver) clazz.newInstance();
            DriverManager.registerDriver(driver);
             conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);
            // 创建statement
            String sql = "Insert into customers(name,email,birth) values(?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, "钟离");
            ps.setString(2, "yan.email");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = (java.util.Date) sdf.parse("2022-11-30");
            ps.setDate(3, new Date(date.getTime()));
            ps.execute();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
