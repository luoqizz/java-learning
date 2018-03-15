package com.brianway.learning.java.base.reflection.test;

import java.lang.reflect.Constructor;
/*
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *
 * 1.获取构造方法：
 *      1).批量的方法：
 *          public Constructor[] getConstructors()：所有"公有的"构造方法
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

 *      2).获取单个的方法，并调用：
 *          public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 *          public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 *          调用构造方法：
 *          Constructor-->newInstance(Object... initargs)
 */
public class ConstructorsDemo {
    public static void main(String[] args) {
        try {
            System.out.println("加载Class对象");
            Class stuClass3 = Class.forName("com.brianway.learning.java.base.reflection.bean.Student");
            System.out.println("获取所有公共构造方法");
            Constructor [] conarray = stuClass3.getConstructors();

            for (Constructor c: conarray) {
                System.out.println(c);
            }
            System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
            Constructor [] conarray01 = stuClass3.getDeclaredConstructors();
            for (Constructor c: conarray01) {
                System.out.println(c);
            }
            System.out.println("*****************获取公有、无参的构造方法*******************************");
            Constructor con01 = stuClass3.getConstructor();
            System.out.println(con01);
            //调用构造方法
            con01.newInstance();
            System.out.println("******************获取私有构造方法，并调用*******************************");
            Constructor con02 = stuClass3.getDeclaredConstructor(String.class);
            System.out.println(con02);
            //不需要安全检查私有方法或属性 可以直接访问
            con02.setAccessible(true);
            con02.newInstance("呵呵");
            System.out.println("******************获取多参数构造方法，并调用*******************************");
            Constructor con03 = stuClass3.getConstructor(int.class,int.class,String.class);
            System.out.println(con03);
            con03.newInstance(1,22,"呵呵");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
