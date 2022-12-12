package com.atguigu7;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
/*
* DAO DATABASE access object 数据的通用操作
* 升级 因为 CustomerDAO 只针对Customer表操作 每次 传入Customer。class 显得冗余 利用反射简化一下

* *
* */

// 封装 增删改查操作
public abstract class BaseDAO<T> {
    private Class<T> clazz = null;
    {
        // 子类对象实例化 时 会加在父类（非静态代码块）
        // this 是子类对象
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType =  (ParameterizedType) genericSuperclass;
        Type[] typeArguments = paramType.getActualTypeArguments(); // 获取了父类的泛型参数；（泛型可能有多个 所以返回数组）
        clazz = (Class<T>) typeArguments[0];
    }
    public int update(Connection conn, String sql, Object... args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0; i< args.length; i++){
                ps.setObject(i+1,args[i]);
            }
//            ps.execute(); // 执行查询操作有返回结果，为true; 增删改 false
            return ps.executeUpdate(); // 返回SQL影响的行数 int
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
    // 查询返回1条记录
    public <T> T getInstance( Connection conn, String sql, Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnLen = rsmd.getColumnCount();
            if(rs.next()){
                T t = (T) clazz.newInstance();
                for(int i=0;i<columnLen;i++){
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(columnLabel);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            closeResource(ps);
            closeResource(rs);
        }
        return null;
    }
    // 查询返回n条记录
    public  <T> ArrayList<T> getForList( Connection conn, String sql, Object... args){
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0; i< args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            ArrayList list= new ArrayList<T>();
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                T t = (T)clazz.newInstance();
                for(int i=0; i<columnCount; i++){
                    String columnName = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(i+1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
    // 返回一个数字 count*
    public <E> E getValue(Connection conn, String sql, Object... args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i =0;i< args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource(ps);
        }
            return null;
    }

    public static void closeResource(Connection conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResource( PreparedStatement ps){
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeResource(ResultSet conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
