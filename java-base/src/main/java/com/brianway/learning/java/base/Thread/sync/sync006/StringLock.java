package com.brianway.learning.java.base.Thread.sync.sync006;

/**
 * synchronized代码块对字符串的锁，注意String常量池的缓存功能
 *
 * 线程B并没有进来，也就说明两个线程持有的是同一个锁，即字符串对象是同一个。
 *
 * @author alienware
 *
 */
public class StringLock {

    public void method() {
        //new String("字符串常量")
//        Object obj = new Object();
        synchronized (new String("字符串常量")) {
            try {
                while(true){
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final StringLock stringLock = new StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
