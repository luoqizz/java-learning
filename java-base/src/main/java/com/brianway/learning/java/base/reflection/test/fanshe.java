package com.brianway.learning.java.base.reflection.test;

import com.brianway.learning.java.base.reflection.bean.Student;

/**
 * 获取Class对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 *  在运行期间，一个类，只有一个Class对象产生
 *
 *  三种方式常用第三种，
 *  第一种对象都有了还要反射干什么。
 *  第二种需要导入类的包，依赖太强，不导包就抛编译错误。
 *  一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法。
 */
public class fanshe {
    public static void main(String[] args) {
        //第一种方法获得Class对象
        Student stu1 = new Student();
        Class stuClass = stu1.getClass();
        System.out.println(stuClass.getName());

        //第二种方法获得Class对象
        Class stuClass2 = new Student().getClass();
        System.out.println(stuClass2.getName());

        //第三种方法获得Class对象
        try {
            Class stuClass3 = Class.forName("com.brianway.learning.java.base.reflection.bean.Student");
            System.out.println(stuClass3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
