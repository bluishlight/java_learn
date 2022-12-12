package com.atguigu3.preparedStatement;
import com.aituigu3.util.JDBCUtils;

import java.sql.*;

public class CustomerForQuery {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet resultSet  = null;
        try {
            conn = JDBCUtils.getConnection("jdbc2.properties");
            System.out.println(conn);
            String sql= "SELECT id,name,email,birth from customers where id = 2";
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            Customer customer = null;
            if(resultSet.next()){ //有数据 返回true 指针下移
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                customer = new Customer(id,name,email,birth);
            }
            System.out.println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn,ps,resultSet);
        }

    }
}
