package com.atguigu.java;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        // 注意这里不能用run

        for(int i=0;i<100;i++){
           System.out.println("@");
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
