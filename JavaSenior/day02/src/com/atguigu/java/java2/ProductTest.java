package com.atguigu.java.java2;

public class ProductTest {
    public static void main(String[] args) {
        Clerk c = new Clerk();
        Producer p1 = new Producer(c);
        p1.setName("生产者");
        Consumer c1 = new Consumer(c);
        c1.setName("消费者1");
        Consumer c2 = new Consumer(c);
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();
    }
}
class Clerk{
    private int productNum =0;
    public synchronized void produceProduct()  {
        if(productNum<20){
            productNum++;
            System.out.println(Thread.currentThread().getName()+"生产产品+1 " + productNum);
            notify();
        }else{
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if(productNum>0){
            System.out.println(Thread.currentThread().getName()+"消耗产品-1 "+ productNum);
            productNum--;
            notify();
        }else{
            try{
                wait();

            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        int i =0;
        while(i<20){
            clerk.produceProduct();
            i++;
        }

    }
}
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        int i =0;
        while(i<10){
            clerk.consumeProduct();
            i++;
        }
    }
}
