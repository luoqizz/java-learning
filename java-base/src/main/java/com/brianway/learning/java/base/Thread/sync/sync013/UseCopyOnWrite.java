package com.brianway.learning.java.base.Thread.sync.sync013;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();

        //所有的方法都是需要获得锁的
        cwal.add("aa");

    }
}
