package cn.sun.elasticsearch.demo;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: sunyufei
 * @Date: 2020-03-05 12:41
 **/
public class ReenterLockInt implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;
    public ReenterLockInt(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                try {
                    lock1.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    try {
                        lock2.lockInterruptibly();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            } else {
                try {
                    lock2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    try {
                        lock1.lockInterruptibly();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread())
                lock1.unlock();
            if (lock2.isHeldByCurrentThread())
                lock2.unlock();
            System.out.println(Thread.currentThread().getId()+"线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockInt r1= new ReenterLockInt(1);
        ReenterLockInt r2 = new ReenterLockInt(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();;t2.start();
        Thread.sleep(1000);
    }
}
