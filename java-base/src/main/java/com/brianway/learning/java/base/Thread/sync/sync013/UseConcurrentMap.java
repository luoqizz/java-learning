package com.brianway.learning.java.base.Thread.sync.sync013;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UseConcurrentMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> chm = new ConcurrentHashMap<String, Object>();
        chm.put("a1","v1");
        chm.put("b1","v2");
        chm.put("c1","v3");
        chm.put("d1","v4");
        chm.putIfAbsent("d1","v5");//如果里面有k等于d1的则不去put

        for (Map.Entry<String,Object> me : chm.entrySet()){
            System.out.println("key:" + me.getKey() + ",value:" + me.getValue());
        }


    }
}
