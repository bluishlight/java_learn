package com.atguigu.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

        // 获取数据库链接 1
//        Driver driver = new com.mysql.cj.jdbc.Driver(); // 这是第三方api
//        String url = "jdbc:mysql://localhost:3306/atguigudb";
//        Properties info = new Properties();
//        info.setProperty("user", "root");
//        info.setProperty("password", "root");
//        Connection conn = driver.connect(url, info);
//        System.out.println(conn);

        // 获取数据库链接 2 反射实现 不出现第三方api 更好可移植性

//        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
//        String url = "jdbc:mysql://localhost:3306/atguigudb";
//        Properties info = new Properties();
//        info.setProperty("user", "root");
//        info.setProperty("password", "root");
//        Connection conn = driver.connect(url, info);
//        System.out.println(conn);

        // 3 DriverManager

//        String url = "jdbc:mysql://localhost:3306/atguigudb";
//        String user = "root";
//        String password = "root";
//        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
//        DriverManager.registerDriver(driver);
//        Connection conn = DriverManager.getConnection(url,user,password);
//        System.out.println(conn);

        // 4 省略 写法

//        String url = "jdbc:mysql://localhost:3306/atguigudb";
//        String user = "root";
//        String password = "root";
//        Class.forName("com.mysql.cj.jdbc.Driver"); // 类的静态代码块里注册了驱动
//      省略  Driver driver = (Driver) clazz.newInstance();
//      省略  DriverManager.registerDriver(driver);
//        Connection conn = DriverManager.getConnection(url,user,password);
//        System.out.println(conn);

        // 5 配置信息封装到配置文件
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties props = new Properties();
        props.load(is);
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driver = props.getProperty("driver");

        Class.forName(driver); // 类的静态代码块里注册了驱动
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
        conn.close();
    }
}
