package com.atguigu.java;
// 单例模式 懒汉式 线程安全版
public class SingletonOne {


    public static void main(String[] args) {
        OnlyOne c1 = OnlyOne.getInstance();
        OnlyOne c2 = OnlyOne.getInstance();
        System.out.println(c1 == c2);
    }

}

class OnlyOne {
    private static OnlyOne instance = null;
//    public static synchronized OnlyOne getInstance(){
//        if(instance == null){
//            instance = new OnlyOne();
//        }
//        return instance;
//    }
    public static OnlyOne getInstance(){
        if(instance == null){ //效率更高
            synchronized (OnlyOne.class){
                if(instance == null){
                    instance = new OnlyOne();
                }
            }
        }
        return instance;
    }
}