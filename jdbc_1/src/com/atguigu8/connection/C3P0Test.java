package com.atguigu8.connection;

import com.aituigu3.util.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test {
    @Test
    public void  testGetConnection() throws PropertyVetoException, SQLException {

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/jdbc_learn" );
        cpds.setUser("root");
        cpds.setPassword("root");
        // 配置属性
        cpds.setInitialPoolSize(10); // 初始连接池 连接数
        Connection conn = cpds.getConnection();
        System.out.println(conn);
        conn.close();
        // 方式2

    }
    @Test
    public  void testGetConnection1() throws SQLException {
//        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
//        Connection conn = cpds.getConnection();
        Connection conn =JDBCUtils.getConnection1();
        System.out.println(conn);
        conn.close();
    }
}
