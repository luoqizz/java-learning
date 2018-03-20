package com.brianway.learning.java.base.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试List中的基本方法
 */
public class Test01 {

    public static void main(String[] args) {
        //ArrayList:底层实现是数组，所以查询快，插入删除慢 不安全效率高
        //LinkedList:底层实现是链表，索引查询慢，插入删除修改快 不安全效率高
        //Vector:线程安全的，效率低

        List list = new ArrayList();


        list.add(1234);//1234本来不是对象，但是因为自动包装类将他包装成Integer
    }
}
