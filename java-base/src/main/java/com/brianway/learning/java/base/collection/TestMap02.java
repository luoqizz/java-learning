package com.brianway.learning.java.base.collection;

import java.util.LinkedList;

public class TestMap02 {
    LinkedList [] arr = new LinkedList[999];//Map的底层结构就是，数组加链表
    int size;

    public void put(Object key,Object value){
        TestEntry t = new TestEntry(key,value);
        int hash = key.hashCode() < 0 ? -key.hashCode():key.hashCode();
        int a =  hash % 999;
        if (arr[a] == null){
            LinkedList list = new LinkedList();
            list.add(t);
            arr[a] = list;
        }else {
            LinkedList list = arr[a];

            for (int i = 0 ; i < list.size(); i++){
                TestEntry t1 = (TestEntry) list.get(i);
                if (t1.key.equals(key)){
                    t1.value = value;
                }else {
                    list.add(t1);
                }
            }
        }
    }

    public Object get(Object key){
        int a = key.hashCode() % 999;
        LinkedList list = arr[a];
        for (int i = 0 ; i < list.size(); i++){
            TestEntry t1 = (TestEntry) list.get(i);
            if (t1.key.equals(key)){
                return t1.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TestMap02 map02 = new TestMap02();
        map02.put("1111","22222");
        map02.put("1111","33333");
        System.out.println(map02.get("1111"));
    }
}
