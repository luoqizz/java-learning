package com.brianway.learning.java.base.jvmDemo;

/**
 * JVM类加载过程
 * 一、加载
 * 1.通过JVM将class文件加载到内存
 * 2.并将这些静态数据转换成方法区中的运行时数据结构
 * 3.在堆中生成一个代表这个类的java.lang.Class对象，作为方法区类数据的访问入口。这个过过程要类加载器进行参与
 *
 * 二、链接
 * 将JAVA类的二进制代码合并到JVM的运行状态之中的过程
 * 1.验证：确保加载类的信息符合JVM规范，没有安全方面的问题。
 * 2.准备：正式为类变量（static变量）分配内存并设置类变量初始值的阶段，这些内存都将在方法区中进行分配
 * 3.解析：虚拟机常量池内的符号引用替换为直接引用的过程。
 *
 * 三、初始化
 * 1.初始化阶段是执行类构造器<clinit>()方法的过程。类构造器<clinit>()方法是由编译器自动收集类中
 * 的所有类变量的赋值动作和静态语句块（static块）中的语句合并产生的。
 * 2.当初始化一个类的时候，如果发现其父类还没有进行过初始化、则需要先触发其父类的初始化
 * 3.虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确加锁和同步。
 * 4.当访问一个Java类的静态域时，只有真正声明这个域的类才会被初始化。
 *
 */
public class JvmDemo01 {
    static {
        System.out.println("初始化Demo01初始化块");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Demo01Main方法");
//        A a = new A();
//        System.out.println(a.width);
//        A a2 = new A();

        //主动引用
//        new A();
//        System.out.println(A.width);
//        Class.forName("com.brianway.learning.java.base.jvmDemo.A");

        //被动引用
//        System.out.println(A.MAX);
//        A[] as = new A[10];
        System.out.println(B.width);
    }
}

class B extends A{
    static {

        System.out.println("静态初始化B");
    }

}

class A extends A_Father{
    public static int width = 300;
    public static final int MAX = 100;
    static {
        System.out.println("初始化静态类A");
        width = 100 ;
    }
    public A(){
        System.out.println("创建A类的对象");
    }
}

class A_Father{
    static{
        System.out.println("初始化A_Father");
    }
}