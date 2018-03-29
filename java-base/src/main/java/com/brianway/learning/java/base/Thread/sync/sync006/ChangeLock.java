package com.brianway.learning.java.base.Thread.sync.sync006;

/**
 * 锁对象的改变问题
 * 下面例子lock改变的是String对象的引用变量
 * 测试后发现，lock.getHashCode();修改后发生变化，即锁发生变化，当线程1执行将锁改变后，线程二才启动，二个线程所拥有的不是
 * 同一把锁所以在线程1执行时，线程2也开始执行。
 * 将锁换成Object后，不修改锁， 线程执行正确 线程1执行完毕才开始执行线程2
 * @author alienware
 *
 */
public class ChangeLock {

    private String lock = "lock";

    private void method(){
        synchronized (lock) {
            System.out.println(lock.hashCode());
            try {
                System.out.println("当前线程 : "  + Thread.currentThread().getName() + "开始");
                lock = "change lock";
                System.out.println(lock.hashCode());
                Thread.sleep(2000);
                System.out.println("当前线程 : "  + Thread.currentThread().getName() + "结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        final ChangeLock changeLock = new ChangeLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        },"t2");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

}