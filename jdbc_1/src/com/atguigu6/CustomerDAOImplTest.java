package com.atguigu6;

import com.aituigu3.util.JDBCUtils;
import com.atguigu3.preparedStatement.Customer;
import com.atguigu4.exer.MyJDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerDAOImplTest {
    private CustomerDAOImpl dao = new CustomerDAOImpl();
    @Test
    public void insert() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1997-06-08");
            Customer cust = new Customer(1,"临光","kxmer.email", new Date(date.getTime()));
            dao.insert(conn, cust);
            System.out.println("成功");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }

    }

    @Test
    public void deleteById() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            dao.deleteById(conn, 25);
            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    public void update() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("2000-01-08");
            Customer cust = new Customer(26,"德克萨斯","dexas.email", new Date(date.getTime()));
            dao.update(conn, cust);
            System.out.println("update成功");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    public void getCustomerById() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            Customer cust =dao.getCustomerById(conn, 30);
            System.out.println("成功"+ cust);
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }

    }

    @Test
    public void getAll() {

        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            ArrayList<Customer> list =  dao.getAll(conn);
            System.out.println("成功");
            for(int i=0;i< list.size();i++){
                System.out.println(list.get(i));
            }
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    public void getCount() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            Long len =  dao.getCount(conn);
            System.out.println("成功 "+ len);
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }

    @Test
    public void getMaxBirth() {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            Date date =  dao.getMaxBirth(conn);
            System.out.println("成功 "+ date);
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            MyJDBCUtils.closeResource(conn);
        }
    }
}