package com.brianway.learning.java.base.Thread;

/**
 * 生产者与消费者模型
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);

        new Thread(p).start();
        new Thread(c).start();
    }

}

class WoTou{
    int id;
    WoTou(int id){
        this.id = id;
    }

    public String toString(){
        return "WoTou:=="+id;
    }
}

class SyncStack{
    int index = 0;
    WoTou[] arrWT = new WoTou[6];

    public synchronized void push(WoTou w){
        while (index == arrWT.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        arrWT[index] = w;
        index++;

    }

    public synchronized WoTou pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return arrWT[index];

    }
}

class Producer implements Runnable{
    SyncStack ss = null;
    Producer(SyncStack ss){
        this.ss = ss;
    }
    @Override
    public void run() {
        for (int i = 0 ; i< 20 ;i++){
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println("生产了馒头"+i);

        }
    }
}


class Consumer implements Runnable{
    SyncStack ss = null;
    Consumer(SyncStack ss){
        this.ss = ss;
    }
    @Override
    public void run() {
        for (int i = 0 ; i< 20 ;i++){
            WoTou wt = ss.pop();
            System.out.println("消费了馒头"+i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
