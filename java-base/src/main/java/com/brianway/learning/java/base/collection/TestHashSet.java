package com.brianway.learning.java.base.collection;

import java.util.HashMap;

public class TestHashSet {

    HashMap map ;
    private static final Object PRESENT = new Object();

    public TestHashSet() {
        map = new HashMap();
    }

    public void add(Object o){
        map.put(o,PRESENT);//SET的不可重复就是利用了map里面建不可重复的特性
    }
}
