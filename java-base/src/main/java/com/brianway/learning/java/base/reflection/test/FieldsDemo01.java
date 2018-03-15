package com.brianway.learning.java.base.reflection.test;

import com.brianway.learning.java.base.reflection.bean.Student;

import java.lang.reflect.Field;

/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 *      1).Field[] getFields():获取所有的"公有字段"
 *      2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 *      1).public Field getField(String fieldName):获取某个"公有的"字段；
 *      2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 *   设置字段的值：
 *      Field --> public void set(Object obj,Object value):
 *                  参数说明：
 *                  1.obj:要设置的字段所在的对象；
 *                  2.value:要为字段设置的值；
 *
 */
public class FieldsDemo01 {
    public static void main(String[] args) {
        //1.获取class对象
        try {
            Class stuClass = Class.forName("com.brianway.learning.java.base.reflection.bean.Student");
            //2.获取字段
            System.out.println("************获取所有公有的字段********************");
            Field [] fs01 = stuClass.getFields();
            for (Field f:fs01 ) {
                System.out.println(f);
            }
            System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
            Field [] fs02 = stuClass.getDeclaredFields();
            for (Field f:fs02 ) {
                System.out.println(f);
            }
            System.out.println("*************获取公有字段**并调用***********************************");
            Field aa = stuClass.getField("aa");
            System.out.println(aa);
            //获取一个对象
            Object obj = stuClass.newInstance();
            aa.set(obj,123);

            //验证
            Student stu = (Student) obj;
            System.out.println(stu.getAa());

            System.out.println("**************获取私有字段****并调用********************************");
            Field name = stuClass.getDeclaredField("name");
            System.out.println(name);
            Object obj1 = stuClass.newInstance();
            name.setAccessible(true);//暴力反射，解除私有限定
            name.set(obj1,"呜呜呜");
            //验证
            Student stu1 = (Student) obj1;
            System.out.println(stu1.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
