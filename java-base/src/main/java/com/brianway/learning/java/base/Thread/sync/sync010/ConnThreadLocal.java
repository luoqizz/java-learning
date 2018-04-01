package com.brianway.learning.java.base.Thread.sync.sync010;

/**
 * ThreadLocal
 * https://www.cnblogs.com/xzwblog/p/7227509.html
 * 该变量的值只能在当前线程中访问，在多个线程之间不是可见的。
 */
public class ConnThreadLocal {
    public static ThreadLocal<String> th = new ThreadLocal<String>();

    public void setTh(String value){
        th.set(value);
    }
    public void getTh(){
        System.out.println(Thread.currentThread().getName() + ":" + this.th.get());
    }

    public static void main(String[] args) {
        final ConnThreadLocal ct = new ConnThreadLocal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.setTh("张三");
                ct.getTh();
            }
        },"t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.getTh();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
