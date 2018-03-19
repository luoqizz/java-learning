package com.brianway.learning.java.base.Thread;

public class TestThread1 {
    public static void main(String[] args) {
        Runner1 r1 = new Runner1();
        Thread t = new Thread(r1);

        t.start();
        for (int i = 0 ; i<100 ; i++){
            System.out.println("Main Thread=="+i);
        }
    }

    static class Runner1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0 ; i<100 ; i++){
                System.out.println("Runner1=="+i);
            }
        }
    }
}
