package com.brianway.learning.java.base.jvmDemo;

/**
 * 类加载器使用的代理模式
 * 双亲委派机制
 * 当加载java.lang.String类时 由应用类加载器 丢给父类扩展类加载器 再丢给父类引导类加载器 如果顶级父类中有则加载该类子类则不执行了，如果父类没有则交给子类执行
 */
public class JvmDemo02 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());//获得当前类加载器 应用类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());//获得当前父类加载器  扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//获得当前父类的父类加载器   引导类加载器



    }
}
