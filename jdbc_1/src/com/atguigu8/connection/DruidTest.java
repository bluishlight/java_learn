package com.atguigu8.connection;

import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTest {
    @Test
    public void getConnection() throws SQLException {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setPassword("root");
        source.setUrl( "jdbc:mysql://localhost:3306/jdbc_learn" );
        source.setUsername("root");

        Connection conn = source.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    public void getConnection1() throws Exception {
        File file = new File("src/druid.properties");
        FileInputStream is = new FileInputStream( file);
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
        is.close();
    }
}
