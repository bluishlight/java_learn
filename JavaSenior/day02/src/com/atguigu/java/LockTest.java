package com.atguigu.java;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        t1.start();
        t2.start();
    }
}

class Window implements Runnable{
    private int tickets =100;
    // 实例化锁
    private ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                if(tickets>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.getStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " -- "+ tickets);
                    tickets--;
                }else{
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}