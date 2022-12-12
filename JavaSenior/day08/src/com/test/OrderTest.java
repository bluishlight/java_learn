package com.test;

import java.util.List;

public class OrderTest {
    public static void main(String[] args) {
        Order<Integer> o1= new Order<>("hahha",123,1);
        Order<Integer> o2= new Order<>("hahha",123,12);
        // 泛型方法调用
        List<Integer> list = o1.copyToList(new Integer[]{1,2,3,4});
        System.out.println(list.toString());
    }
}
