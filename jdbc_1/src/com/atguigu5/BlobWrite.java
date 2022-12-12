package com.atguigu5;

import com.atguigu4.exer.MyJDBCUtils;

import java.io.*;
import java.sql.*;

public class BlobWrite {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        BufferedInputStream bis = null;
        ResultSet rs = null;
        try {
            conn = MyJDBCUtils.getConnection();
            System.out.println(conn);
            String sql = "select name,email,birth,photo from  customers where id =29";
            ps = conn.prepareStatement(sql);
            File optfile = new File("rock_copy.PNG");
            rs = ps.executeQuery();
            if(rs.next()){
                String name = rs.getString(1);
                System.out.println("name "+name);
                Date date = rs.getDate("birth");
                System.out.println(date);
                Blob photo = rs.getBlob(4);
                InputStream is = photo.getBinaryStream();
                OutputStream os = new FileOutputStream(optfile);
                byte[] buffer = new byte[8];
                int length;
                while((length = is.read(buffer))!=-1){
                    os.write(buffer,0,length);
                }
                os.close();
                is.close();
            }

        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
