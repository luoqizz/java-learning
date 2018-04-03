package com.brianway.learning.java.base.Thread.sync.sync013;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityBlockingQueue 存放的类必须实现compareTo 排序方法
 * add时并不会对存放的元素排序而是在 take时对PriorityBlockingQueue进行排序
 * 这种设计只需要take时在去排序 不会影响性能
 */
public class UsePriorityBlockingQueue {


    public static void main(String[] args) throws Exception{


        PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();

        Task t1 = new Task();
        t1.setId(3);
        t1.setName("id为3");
        Task t2 = new Task();
        t2.setId(4);
        t2.setName("id为4");
        Task t3 = new Task();
        t3.setId(1);
        t3.setName("id为1");

        //return this.id > task.id ? 1 : 0;
        q.add(t1);	//3
        q.add(t2);	//4
        q.add(t3);  //1

        // 1 3 4
        System.out.println("容器：" + q);
        System.out.println(q.take().getId());
        System.out.println("容器：" + q);
//		System.out.println(q.take().getId());
//		System.out.println(q.take().getId());



    }
}

