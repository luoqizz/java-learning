package com.brianway.learning.java.base.Thread.sync.sync007;

/**
 * volatile 当一个变量由volatile修饰以后，则当该变量发生改变后会强制通知线程将改变后的属性重新读取到线程独有的内存区
 * 增加volatile后，能够做到修改变量即可让其他使用到该变量的线程及时接受到最新的值。
 */
public class RunThread extends Thread{

    private volatile boolean isRunning = true;
    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    public void run(){
        System.out.println("进入run方法..");
        int i = 0;
        while(isRunning == true){
            //..
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread rt = new RunThread();
        rt.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
    }


}

