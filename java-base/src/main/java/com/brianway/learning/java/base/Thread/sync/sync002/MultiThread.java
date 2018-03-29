package com.brianway.learning.java.base.Thread.sync.sync002;
/**
 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
 * 所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
 *
 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
 * @author alienware
 *
 */
public class MultiThread extends Thread{
    private static int num = 0;

    /**
     * 如果方法不加synchronized则会出现 线程同时去访问printNum方法导致进入a赋值100完毕后休眠100毫秒的时间，进入了b方法
     * 将num修改为200，而a线程休眠结束后在执行则取到了200 导致线程问题。
     * 而在方法上增加synchronized锁后每个线程去访问printNum方法时都需要先去获得方法的锁去执行方法，结果正确。
     * @param tag
     */
    public synchronized static void printNum(String tag){
        try {
            if(tag.equals("a")){
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            }else {
                num = 200;
                System.out.println("tag b, set num over!");
            }
            System.out.println("tag " + tag + ", num = " + num);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //注意观察run方法输出顺序
    public static void main(String[] args) {
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });
        t1.start();
        t2.start();
    }
}
