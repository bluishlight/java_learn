package com.atguigu4.exer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class MyJDBCUtils {
    public static Connection getConnection(){
        try {
            Properties properties = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc2.properties");
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driver");
            Class clazz = Class.forName(driverClass);
            Driver driver = (Driver) clazz.newInstance();
            DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;

    }
    public static int modifyTable(Connection conn, String sql, Object... args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0; i< args.length; i++){
                ps.setObject(i+1,args[i]);
            }
//            ps.execute(); // 执行查询操作有返回结果，为true; 增删改 false
            return ps.executeUpdate(); // 返回SQL影响的行数
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
    public  static <T> ArrayList<T> queryTable(Class<T> clazz ,Connection conn, String sql, Object... args){
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0; i< args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            ArrayList list= new ArrayList<T>();
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                T t = clazz.newInstance();
                for(int i=0; i<columnCount; i++){
                    String columnName = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
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
        return null;

    }
    public static void closeResource(Connection conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResource( PreparedStatement ps){
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResource(ResultSet conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
