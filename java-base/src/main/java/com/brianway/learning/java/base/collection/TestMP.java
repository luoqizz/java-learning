package com.brianway.learning.java.base.collection;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class TestMP {
    public static void main(String[] args) {
        int [] arry = {3,2,1,4,5,6,85,11,22};
        boolean sorted = true;
        for(int j = 0 ; j < arry.length-1 ; j++){
            for(int i = 0 ; i < arry.length-1-j ;i++){// -j 每趟缩小1一次 因为最后一位每次都是最大的
                if (arry[i]>arry[i+1] ){
                    int temp = arry[i];
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
