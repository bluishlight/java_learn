package com.atguigu3.preparedStatement;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 建立连接
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc2.properties");
            Properties properties = new Properties();
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver =  properties.getProperty("driver");
            Class clazz = (Class) Class.forName(driver);
            Driver driver1 = (Driver) clazz.newInstance();
            DriverManager.registerDriver(driver1);
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);
            // 创建statement  sql
            String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"阿贝多");
            ps.setString(2,"genshin.email");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date =  sdf.parse("2000-01-10");
            ps.setDate(3, new Date(date.getTime()));
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                ps.close();
            }
            if(conn !=null){
                conn.close();
            }
        }

    }
}
