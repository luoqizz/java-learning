package com.brianway.learning.java.base.Thread;

import java.util.Date;

/**
 * 太粗暴不推荐 interrupt 还可以在catch里面执行后续操作
 * stop 是直接关闭线程
 */
public class TestInterrupt {
    public static void main(String[] args) {
        MyRunner mr = new MyRunner();
        Thread r = new Thread(mr);
        r.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.interrupt();//打断当前进程

    }


    static class MyRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("===="+new Date()+"====");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
