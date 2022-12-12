package com.atguigu7;

import com.atguigu3.preparedStatement.Customer;
import com.atguigu7.BaseDAO;
import com.atguigu7.CustomerDAO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

//获取CustomerDAOImpl父类的泛型
public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {

    @Override
    public void insert(Connection conn, Customer cust) {
        String sql ="INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql ="DELETE FROM customers WHERE id=?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customer cust) {
        String sql ="UPDATE customers SET name=?, email=?, birth=? WHERE id =?";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql ="SELECT id,name,email,birth FROM customers WHERE id = ?";
        return getInstance(conn,sql, id);
    }

    @Override
    public ArrayList<Customer> getAll(Connection conn) {
        String sql ="SELECT id,name,email,birth FROM customers";
        ArrayList<Customer> list = getForList(conn,sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql ="SELECT COUNT(*) FROM customers";
        return getValue(conn,sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql ="SELECT MAX(birth) FROM customers";
        return getValue(conn,sql);
    }
}
