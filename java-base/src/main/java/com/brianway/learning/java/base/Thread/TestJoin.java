package com.brianway.learning.java.base.Thread;

/**
 * t1.join 合并线程 将本来可以单独执行的线程 合并到主线程中
 */
public class TestJoin {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("aaaa");


        t1.start();

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for (int i = 0 ; i< 10; i++){
            System.out.println("i am main thread");
        }
    }
}

class MyThread2 extends Thread{
    MyThread2(String s){
        super(s);
    }

    public void run(){
        for (int i = 0 ; i < 10 ; i++){
            System.out.println("i am" +getName());

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}