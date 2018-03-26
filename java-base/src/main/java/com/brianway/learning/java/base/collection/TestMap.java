package com.brianway.learning.java.base.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("张三",new Wife("呵呵"));
        map.put("李四",new Wife("huhu"));

        map.remove("张三");

        Wife w = (Wife) map.get("张三");
        System.out.println(w.name);
    }
}

class Wife{
    String name;
    public Wife(String name){
        this.name = name;
    }
}
