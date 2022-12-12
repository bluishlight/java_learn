package exer;

public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        t1.setName("窗口1");
        Window t2 = new Window();
        t2.setName("窗口2");
        Window t3 = new Window();
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window extends Thread{
    private static int total = 100;

    @Override
    public void run() {
        super.run();
        while(total>0){
            System.out.println(Thread.currentThread().getName()+" 第 "+total--);
        }
    }
}