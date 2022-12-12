package exer;


// start run sleep stop yield join

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne("线程1---");
        ThreadTwo t2 = new ThreadTwo();
        t2.start(); // 启动线程
        t1.setPriority(9);
        t1.start();
        new Thread(){ //匿名对象
            public void run(){
                for(int i=0;i<100;i++){
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+"哈哈");
                    }
                    if(i==50){
                        System.out.println(Thread.currentThread().getName()+"释放cpu");
                        yield();
                    }
                }
            }
        }.start();

        System.out.println("!:"+Thread.currentThread().getName());
        System.out.println("优先级"+ Thread.currentThread().getPriority());
    }
}

class ThreadOne extends Thread{
    ThreadOne(String name){
        super(name);
    }


    @Override
    public void run() {
        super.run();
        for(int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+"优先"+getPriority());
            }
        }
    }
}

class ThreadTwo extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}