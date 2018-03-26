package com.brianway.learning.java.base.collection;

import java.util.Arrays;

/**
 * 冒泡排序 减少趟数，如果一趟中没有发生位置改变则下面不执行了
 */
public class TestStringPX {
    public static void main(String[] args) {
        String [] arry = {"a","b","c","dd","aa","jj"};
        boolean sorted = true;
        for(int j = 0 ; j < arry.length-1 ; j++){
            for(int i = 0 ; i < arry.length-1-j ;i++){// -j 每趟缩小1一次 因为最后一位每次都是最大的
                if ((arry[i].compareTo(arry[i+1]))> -1 ){
                    String temp = arry[i];
                    arry[i] = arry[i+1];
                    arry[i+1] = temp;
                    sorted = false;
                }
            }
            if (sorted){//减少趟数
                break;
            }
        }



        System.out.println( Arrays.toString(arry));
    }
}
