package com.atguigu4.exer;

import com.atguigu3.preparedStatement.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MyExer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入身份证号");
        String idcard = scanner.next();
        System.out.println(idcard + "!!!");

        Connection conn = null;
        try {
            conn = MyJDBCUtils.getConnection();
            System.out.println(conn);
            String sql = "select * from examstudent where IDCard =? ";
            ArrayList<ExamStudent> arr= MyJDBCUtils.queryTable(ExamStudent.class, conn,sql,idcard);
            System.out.println("查询结果");
            arr.forEach(System.out::println);
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
