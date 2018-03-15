package com.brianway.learning.java.base.reflection.bean;

/**
 * 反射基础Bean
 * http://blog.csdn.net/sinat_38259539/article/details/71799078
 */
public class Student {
    private int id;
    private int age;
    private String name;
    public int aa;

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
        System.out.println("我是无参构造方法");
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;

        System.out.println("id:"+id+"==age:"+age+"===name:"+name);
    }

    private Student(String name) {
        System.out.println("你好："+name);
    }

}
