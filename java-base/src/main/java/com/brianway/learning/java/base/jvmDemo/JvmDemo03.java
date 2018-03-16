package com.brianway.learning.java.base.jvmDemo;

/**
 *
 */
public class JvmDemo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loder = new FileSystemClassLoader("d:/myclass");

        FileSystemClassLoader loder1 = new FileSystemClassLoader("d:/myclass");
        Class c =  loder.loadClass("com.lq.test.Student");
        Class c4 =  loder.loadClass("com.lq.test.Student");
        Class c3 =  loder1.loadClass("com.lq.test.Student");

        Class c1 = loder.loadClass("java.lang.String");
        Class c2 = loder.loadClass("com.brianway.learning.java.base.jvmDemo.A");
        System.out.println(c);
        System.out.println(c.getClassLoader());
        System.out.println(c1.getClassLoader());
        System.out.println(c2.getClassLoader());

        System.out.println("=========================");
        System.out.println(c.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c3.hashCode());
    }
}
