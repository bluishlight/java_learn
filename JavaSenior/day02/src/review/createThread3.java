package review;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
创建线程方式
1 继承thread
2 实现Runnable
3 实现Callable
4 ThreadPool （常用）
 */
public class createThread3 {
    public static void main(String[] args) {
        ThreadThree w = new ThreadThree();
        FutureTask ft1 = new FutureTask(w);
        Thread t1 =  new Thread(ft1);
        t1.start();
        FutureTask ft2 = new FutureTask(w);
        Thread t2 =  new Thread(ft2);
        t2.start();
        try{
            Object k = ft1.get();
            System.out.println("k" + k);
            Object k2 = ft1.get();
            System.out.println("k：" + k2);
        } catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadThree implements Callable{
    private int tickets = 50;
    private synchronized Boolean show(){
        if(tickets>0){
            System.out.println(Thread.currentThread().getName()+"--"+tickets);
            tickets--;
            return false;
        }
        return true;
    }
    @Override
    public Object call() throws Exception {
        while (true){
            if(show()) break;
        }
        return 123;
    }
}