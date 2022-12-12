package review;
/*
创建线程方式
1 继承thread
2 实现Runnable
3 实现Callable
4 ThreadPool （常用）

 */
public class createThread1 {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadOne t2 = new ThreadOne();
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class ThreadOne extends Thread{
    private static int tickets = 100;

    @Override
    public void run() {
        super.run();
        while (true){
            synchronized (ThreadOne.class) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread() + "--" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}