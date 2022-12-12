package com.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getClassTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // 获取Class 运行时类 4种方法
        // 1 运行时类的属性
        Class clazz1 = Person.class;
        // 2 运行时类的对象
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz1 == clazz2);
        // 3 Class的静态方法 重点 体现动态性
        Class clazz3 = Class.forName("com.java.Person");
        System.out.println(clazz1 == clazz3);
        // 4 类的加载器（了解）
        ClassLoader classLoader = getClassTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.java.Person");
        System.out.println(clazz1 == clazz4);
        // **********
        Properties properties = new Properties();
        String absPath = "D:\\project\\workspace\\workspace_idea1\\JavaSenior\\day11\\jdbc.properties";
        //
//        FileInputStream fis = new FileInputStream(absPath); // 相对路径day11
//        properties.load(fis);
        //
        ClassLoader classLoader1 = getClassTest.class.getClassLoader();
        // 注意下面相对路径src
        InputStream ips = classLoader1.getResourceAsStream("jdbc1.properties");
        properties.load(ips);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user+ " "+password);


    }
}
