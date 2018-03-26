package com.brianway.learning.java.base.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计各个单词出现了多少次
 */
public class TestMap03 {
    public static void main(String[] args) {
        char str [] = "abcdefggjlkjioqwtiojjkfldasngjhagvcadsg".toCharArray();
        int ONE= 1;
        Map map = new HashMap();
        for (int i = 0 ; i < str.length ; i ++){
            if(!map.containsKey(str[i])){
                map.put(str[i],ONE);
            }else {
                int num = (int) map.get(str[i]);
                map.put(str[i],num+1);
            }
        }

        System.out.println(map.toString());

    }

}
