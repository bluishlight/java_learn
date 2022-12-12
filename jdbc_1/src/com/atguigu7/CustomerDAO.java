package com.atguigu7;

import com.atguigu3.preparedStatement.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

// 定义针对Customers表的操作规范
public interface CustomerDAO {
    // 将cust对象添加到数据库中
    void insert(Connection conn, Customer cust);
    // 删除指定id数据
    void deleteById(Connection conn, int id);
    // 改指定记录
    void update(Connection conn, Customer cust);
    // 查对象
    Customer getCustomerById(Connection conn, int id);
    // 查询所有数据
    ArrayList<Customer> getAll(Connection conn);
    // 数据记录条数
    Long getCount(Connection conn);

    // 最大员工生日
    Date getMaxBirth(Connection conn);

}
