package com.atguigu3.preparedStatement;
import com.aituigu3.util.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class OrderForQuery {
    public static void main(String[] args) {
        Connection conn = JDBCUtils.getConnection("jdbc2.properties");
        System.out.println(conn);
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate " +
//                "FROM `order` " +
//                "WHERE order_id = ?;";
//        Order o = JDBCUtils.queryOrder(conn,ps,rs,sql,"4");

//        Order o =  JDBCUtils.getInstance(Order.class, conn,sql,"4");
//        System.out.println("这里"+o);
        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate " +
                "FROM `order` ";
        ArrayList list = JDBCUtils.getForList(Order.class, conn,sql);
        list.forEach(System.out::println);
//        System.out.println(ps);
//        JDBCUtils.closeConnection(conn,ps,rs);
//        Date date = new Date();
//        date.getTime()
//        Order ok = null;
//        ok = new Order(1,"name", new java.sql.Date(date.getTime()));
//        System.out.println(ok);
//        changeOrd(ok );
//        System.out.println(ok);
    }
    static  void changeOrd(Order od){
        System.out.println("内部od1  "+od);
        Date date = new Date();
        od =  new Order(2,"name222", new java.sql.Date(date.getTime()));
        System.out.println("内部od"+od);
    }
}
