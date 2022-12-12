package com.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) {
        //1.创建Person类的对象
//        Person p1 = new Person("Tom", 12);
//
//        //2.通过对象，调用其内部的属性、方法
////        p1.age = 10;
//        System.out.println(p1.toString());
//
//        p1.show();
        try{
//            Class clazz = Person.class;
//            Constructor cons = clazz.getConstructor(String.class, int.class);
//            Object obj =  cons.newInstance("TOM",12);
//            System.out.println(obj);
//            Person p = (Person) obj;
//            System.out.println(p);
//            Field age = clazz.getDeclaredField("age");
//            age.set(p,10);
//            System.out.println(p);

            Class clazz = Person.class;
            //1.通过反射，创建Person类的对象
            Constructor cons = clazz.getConstructor(String.class,int.class);
            Object obj = cons.newInstance("Tom", 12);
            Person p = (Person) obj;
            System.out.println(p.toString());
            //2.通过反射，调用对象指定的属性、方法
            //调用属性
            Field age = clazz.getDeclaredField("age");
            age.set(p,10);
            System.out.println(p.toString());

            Method show = clazz.getDeclaredMethod("show");
            show.invoke(p);
            // ********************私有构造器
            Class clazz2 = Person.class;
            Constructor cons2 = clazz2.getDeclaredConstructor(String.class);
            cons2.setAccessible(true); // 关键
            Object obj2 =cons2.newInstance("jerry");
            Person p2 = (Person) obj2;
            System.out.println(p2.toString());
            // 私有属性
            Field name = clazz2.getDeclaredField("name");
            name.setAccessible(true);
            name.set(p2,"新名字");
            System.out.println(p2);

        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
