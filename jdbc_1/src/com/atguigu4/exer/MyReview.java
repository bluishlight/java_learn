package com.atguigu4.exer;

import com.atguigu3.preparedStatement.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyReview {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            System.out.println(conn);
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date d = sdf.parse("2003-08-18");
//            Date date = new Date(d.getTime());
            int linesAffected = MyJDBCUtils.modifyTable(conn,sql,"灵光","zw.email","2003-08-18");
            System.out.println(linesAffected);
            //***********
//            String sql = "select id,name,email,birth from customers";
//            ArrayList<Customer> arr= MyJDBCUtils.queryTable(Customer.class, conn,sql);
//            arr.forEach(System.out::println);
        } finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
