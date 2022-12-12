package com.atguigu8.connection;

import com.aituigu3.util.JDBCUtils;
import com.atguigu3.preparedStatement.Customer;
import com.atguigu4.exer.MyJDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryRunnerTest {
    @Test
    public  void testInsert() throws SQLException {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();

            conn = JDBCUtils.getConnection1();
            String sql = "Insert into customers(name,email,birth)values(?,?,?)";
            int insertCount = runner.update(conn,sql,"大大利亚","gz.email","1997-08-09");
            System.out.println(insertCount);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }
    @Test
    public  void testQuery1() throws SQLException {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();

            conn = JDBCUtils.getConnection1();
            String sql = "select id,name,email,birth from customers where id =?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class); // 存储结果的
            Customer customer = runner.query(conn,sql,handler,23);
            System.out.println(customer);
            // 多数据查询
            BeanListHandler<Customer> handler2 = new BeanListHandler<>(Customer.class);
            String sql2 = "select id,name,email,birth from customers where id < ?";
            List<Customer> customers = runner.query(conn,sql2,handler2,23);
            customers.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }
    @Test
    public void testQuery3(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection1();
            MapHandler handler = new MapHandler();
            String sql = "select id,name,email,birth from customers where id =?";
            Map<String, Object> map = runner.query(conn, sql,handler,23);
            System.out.println(map);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    public void testQuery4(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection1();
            MapListHandler handler = new MapListHandler();
            String sql = "select id,name,email,birth from customers where id < ?";
            List<Map<String, Object>> list = runner.query(conn, sql,handler,13);
            list.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            MyJDBCUtils.closeResource(conn);
        }
    }
    // ScalarHandler特殊值查询
    @Test
    public void testQuery5(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection1();
            ScalarHandler handler = new ScalarHandler();
            String sql = "select count(*) from customers ";
            Long count= (Long) runner.query(conn, sql,handler);
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            MyJDBCUtils.closeResource(conn);
        }
    }
    @Test
    public void testQuery6(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection1();
            ScalarHandler handler = new ScalarHandler();
            String sql = "select max(birth) from customers ";
            Date date= (Date) runner.query(conn, sql,handler);
            System.out.println(date);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

}
