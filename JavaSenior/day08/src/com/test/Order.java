package com.test;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    T orderT;
    private int orderId;
    private  String orderName;
    public Order(){};
    T[] arr;
    public Order(String orderName, int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
        T[] arr = (T[]) new Order[10];
        this.arr = arr;
    }
    // 泛型方法
    public  <E> List<E> copyToList(E[] array){
        ArrayList<E> list= new ArrayList<>();
        for(E element: array){
            list.add(element);
        }
        return  list;
    }
    //  可以是静态的 参数是在调用时确认的
    public static <E> List<E> copyToList2(E[] array){
        ArrayList<E> list= new ArrayList<>();
        for(E element: array){
            list.add(element);
        }
        return  list;
    }
}
