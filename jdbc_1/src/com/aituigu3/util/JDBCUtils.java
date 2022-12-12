package com.aituigu3.util;

import com.atguigu3.preparedStatement.Customer;
import com.atguigu3.preparedStatement.Order;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class JDBCUtils {
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs){
        DbUtils.closeQuietly(rs);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(conn);
    }
    private static DataSource source;
    static  {
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection testGetConnection2() throws Exception {
        return source.getConnection();
    }

    private static final ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();
        System.out.println(conn);
        return conn;
    }
    public static Connection getConnection(String propertiesStr){
        Connection conn = null;
        try {

            Properties properties = new Properties();
//        InputStream is = PreparedStatementReview.class.getClassLoader().getResourceAsStream("jdbc2.properties");
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(propertiesStr);
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            Class clazz = Class.forName(driver);
            Driver driver1 = (Driver) clazz.newInstance();
            DriverManager.registerDriver(driver1);
            conn = DriverManager.getConnection(url,user,password);
            return conn;
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
        }
        finally {
            return conn;
        }
    }
    public static void closeConnection( Connection conn, PreparedStatement ps ){
        if(ps != null){
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
    }

    public static void closeConnection( Connection conn, PreparedStatement ps, ResultSet rs ){
        if(ps != null){
            try {
                ps.close();
                System.out.println("ps 关闭连接");
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
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public  static void commonUpdate(Connection conn, PreparedStatement ps, String sql,Object... args) throws Exception{
        try {

            ps = conn.prepareStatement(sql);
            for(int i=0;i< args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // 只针对Customer表 且sql只返回一条
    public static Customer queryCustomer(Connection conn,PreparedStatement ps, String sql, Object...args) throws SQLException {
        ps = conn.prepareStatement(sql);
        for(int i=0;i< args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        ResultSet resultSet = ps.executeQuery();
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnLen = rsmd.getColumnCount();

        if(resultSet.next()){ //有数据 返回true 指针下移
            try {
                Customer customer = new Customer();
                for (int i = 0; i < columnLen; i++) {
                    String ColumnName = rsmd.getColumnName(i + 1);
                    Object object = resultSet.getObject(i+1);
                    Field field = Customer.class.getDeclaredField(ColumnName);
                    field.setAccessible(true);
                    field.set(customer, object);
                }

                System.out.println(customer);
                return customer;
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public static Order queryOrder(Connection conn, PreparedStatement ps, ResultSet rs,String sql, Object... args){
        try {
            ps = conn.prepareStatement(sql);
            for(int i=0;i< args.length;i++){
                ps.setObject(i+1, args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                Order result = new Order();
                for(int i=0;i<columnCount;i++){
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(result,columnValue);
                }
                return result;
            }

        } catch (SQLException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn,  ps,  rs);
        }

        return null;
    }


    public static <T> T getInstance(Class<T> clazz, Connection conn, String sql, Object... args){
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i=0;i< args.length;i++){
                ps.setObject(i+1, args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                T result = clazz.newInstance();
                for(int i=0; i < columnCount;i++){
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(result,columnValue);
                }
                return result;
            }

        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn,  ps,  rs);
        }

        return null;
    }

    public static <T> ArrayList<T> getForList(Class<T> clazz, Connection conn, String sql, Object... args){
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            ArrayList<T> list = new ArrayList<T>();
            ps = conn.prepareStatement(sql);
            for(int i=0;i< args.length;i++){
                ps.setObject(i+1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                T t = clazz.newInstance();
                for(int i=0; i < columnCount;i++){
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (SQLException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn,  ps,  rs);
        }

        return null;
    }
//    public static <T> T queryResult(Connection conn,PreparedStatement ps, String sql, Object...args) throws SQLException {
//        ps = conn.prepareStatement(sql);
//        for(int i=0;i< args.length;i++){
//            ps.setObject(i+1,args[i]);
//        }
//        ResultSet resultSet = ps.executeQuery();
//        ResultSetMetaData rsmd = resultSet.getMetaData();
//        int columnLen = rsmd.getColumnCount();
//
//        if(resultSet.next()){ //有数据 返回true 指针下移
//            try {
//                T customer = new T();
//                for (int i = 0; i < columnLen; i++) {
//                    String ColumnName = rsmd.getColumnName(i + 1);
//                    Object object = resultSet.getObject(i+1);
//                    Field field = T.class.getDeclaredField(ColumnName);
//                    field.setAccessible(true);
//                    field.set(customer, object);
//                }
//
//                System.out.println(customer);
//                return customer;
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
}
