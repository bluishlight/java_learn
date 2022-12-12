package com.atguigu.java.java2;

public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class Number implements Runnable{
    private int num=0;
    public void run(){
        while(true){
            synchronized (this) {
                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + "--" + num);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num++;
                    if((num-1)%5==0){
                        try{
                            wait();
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                } else {
                    break;
                }

            }
        }
    }
}