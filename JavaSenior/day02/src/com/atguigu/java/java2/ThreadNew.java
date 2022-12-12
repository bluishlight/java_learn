package com.atguigu.java.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) {
        NumThread thread = new NumThread();
        FutureTask ft = new FutureTask(thread);
        new Thread(ft).start();
        try{
            Object sum = ft.get();
            System.out.println("总和为：" + sum);
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable{
    private int count=0;
    private int sum=0;
    @Override
    public Object call() throws Exception {
        while (count<=100){
            if(count%2==0){
                System.out.println(""+count);
                sum+=count;
            }
            count++;
        }
        return sum;
    }
}
// 1 创建实现 Callable 的类
// 2 实现call方法，将此线程需要执行的操作声明在call()中
// 3 创建Callable接口实现类的对象
// 4 将此实例 作为参数 创建FutureTask的对象
// 5 将FutureTask的对象作为参数传递到Thread类的构造器中 创建Thread对象，并调用start()
// 6 6.获取Callable中call方法的返回值 get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。