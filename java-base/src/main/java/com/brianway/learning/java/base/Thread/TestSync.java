package com.brianway.learning.java.base.Thread;

/**
 * synchronized锁
 */
public class TestSync implements Runnable {
    Timer t = new Timer();
    public static void main(String[] args) {
        TestSync test = new TestSync();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("T1");
        t2.setName("T2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        t.add(Thread.currentThread().getName());
    }
}

class Timer{
    private static int num = 0;
    public void add(String name){
//        synchronized (this){
            num ++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +",你是第"+num+"个使用timer方法的线程");
//        }

    }
}