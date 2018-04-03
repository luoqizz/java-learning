package com.brianway.learning.java.base.Thread.sync.sync014;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FutureClient fc = new FutureClient();
        Data data = fc.request("请求参数");
        Data data1 = fc.request("请求参数2");
        System.out.println("请求发送成功!");
        System.out.println("做其他的事情...");

        String result = data.getRequest();
        String result1 = data1.getRequest();
        System.out.println(result);
        System.out.println(result1);
    }
}
