package exer;

import java.util.concurrent.locks.ReentrantLock;

public class AccountTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Account acct = new Account();
        Customer c1 = new Customer(acct,lock);
        Customer c2 = new Customer(acct,lock);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
class Account{
    private int amount = 0;
    public void deposit(double amt){
        amount += amt;
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" 存钱 1000后 余额"+amount);
    }
}

class Customer extends Thread{
    private Account account;
    private ReentrantLock lock;
    public Customer(Account account, ReentrantLock lock){
        this.account = account;
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        for(int i=0;i<3;i++){
            lock.lock();
            this.account.deposit(1000);
            lock.unlock();
        }

    }
}
