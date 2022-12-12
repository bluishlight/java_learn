package com.atguigu3.preparedStatement;
import com.aituigu3.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class CustomerQueryShort {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet resultSet  = null;
        try {
            conn = JDBCUtils.getConnection("jdbc2.properties");
            System.out.println(conn);
//            String sql= "SELECT id,name,email,birth from customers where id = ?";

//            Customer c = JDBCUtils.queryCustomer(conn,ps,sql, "1");
//            System.out.println(c);
//            Customer c = JDBCUtils.getInstance(Customer.class,conn,sql, "1");
//            System.out.println(c);
            String sql= "SELECT id,name,email,birth from customers";
            ArrayList list = JDBCUtils.getForList(Customer.class,conn,sql);
            list.forEach(System.out::println);
        } finally {

//            System.out.println(ps);
//            JDBCUtils.closeConnection(conn,ps,resultSet);
        }

    }
}
