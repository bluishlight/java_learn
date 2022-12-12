package review;
/*
创建线程方式
1 继承thread
2 实现Runnable
3 实现Callable
4 ThreadPool （常用）

 */
public class createThread2 {
    public static void main(String[] args) {
        ThreadTwo r = new ThreadTwo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}

class ThreadTwo implements Runnable{
    private int tickets =100;
    private synchronized  Boolean show(){
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "--" + tickets);
            tickets--;
            return false;
        }
        return true;
    }
    @Override
    public  void run() {
        while (true){
                if(show()) break;
            }
        }
}
