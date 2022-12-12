package exer;

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements  Runnable{
    private int tickets = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            // 同步监视器
            synchronized(obj){ // this 写法
                if(tickets>0) {
                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " -- " + tickets--);

                }else{
                    break;
                }
            }
        }

//
//        synchronized(new Object()){
//        }
    }
}