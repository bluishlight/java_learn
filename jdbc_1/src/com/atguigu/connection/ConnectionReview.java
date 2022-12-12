package com.atguigu.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionReview {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

//        String url="jdbc:mysql://localhost:3306/atguigudb";
//        String user = "root";
//        String password ="root";
//        String Diver = "";
//        Properties properties = new Properties();
//        properties.setProperty("user", user);
//        properties.setProperty("password", password);
//        Driver driver = new com.mysql.cj.jdbc.Driver(); // 这是第三方api
//        Connection conn = driver.connect(url, properties);
//        System.out.println(conn);
//        conn.close();

        // m2
//        String url="jdbc:mysql://localhost:3306/atguigudb";
//        String user = "root";
//        String password ="root";
//        String Diver = "";
//        Properties properties = new Properties();
//        properties.setProperty("user", user);
//        properties.setProperty("password", password);
//        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver)clazz.newInstance();
//                Connection conn = driver.connect(url, properties);
//        System.out.println(conn);
//        conn.close();

        InputStream is = ConnectionReview.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String url= properties.getProperty("url");
        String user = properties.getProperty("user");
        String password =properties.getProperty("password");
        String Diver =properties.getProperty("driver");
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver)clazz.newInstance();
//        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
        conn.close();
    }
}
