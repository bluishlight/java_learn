package com.atguigu5;
import com.atguigu4.exer.MyJDBCUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class BlobTest {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        BufferedInputStream bis = null;
        try {
            conn = MyJDBCUtils.getConnection();
            System.out.println(conn);
            String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            File file = new File("rock.PNG");
            System.out.println(file.getAbsolutePath());
            InputStream is = new FileInputStream(new File("rock.PNG"));
            bis = new BufferedInputStream(is);
            ps.setObject(1,"海尔");
            ps.setObject(2,"海尔邮箱");
            ps.setObject(3,"2077-08-09");
            ps.setBlob(4, bis);
            ps.execute();

        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
