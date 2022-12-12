package exer;

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 implements Runnable{
    private int tickets = 100;
    @Override
    public void run() {

        while(tickets>0){
            System.out.println(Thread.currentThread().getName()+" -- "+ tickets--);
        }
    }
}
