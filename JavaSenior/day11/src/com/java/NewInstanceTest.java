package com.java;

import java.util.Random;

public class NewInstanceTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance(); // 运行时类 对象
        // newInstance 里面调用了 运行时类的空参构造器 要有足够权限 default 、 public

        System.out.println(p);

        int x = new Random().nextInt(3);
        String path="";
        switch (x) {
            case 0:
                path = "java.util.Date";

                break;
            case 1:
                path = "java.lang.Object";
                break;
            default:
                path = "com.java.Person";

        }
        System.out.println(Sample.getInstance(path));

    }
}
class Sample{

    public static Object getInstance(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(path);
        return  clazz.newInstance();
    }
}