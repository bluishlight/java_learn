package com.atguigu8.connection;

import com.aituigu3.util.JDBCUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCPTest {
    public void testGetConnection(){

//        创建连接池
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setPassword("root");
        source.setUrl( "jdbc:mysql://localhost:3306/jdbc_learn" );
        source.setUsername("root");

        source.setInitialSize(10);
    }

    @Test
    public void testGetConnection1() throws Exception {
//        Properties pros = new Properties();
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
//        pros.load(is);
//        DataSource source = BasicDataSourceFactory.createDataSource(pros);
//        Connection conn = source.getConnection();

        Connection conn = JDBCUtils.testGetConnection2();
        System.out.println(conn);
        conn.close();
    }
}

