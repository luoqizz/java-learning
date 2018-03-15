package com.brianway.learning.java.base.reflection.test;

import com.brianway.learning.java.base.reflection.bean.Student;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射中泛型的获取
 */
public class GenericDemo {
    public void test01(Map<String,Student> map, List<Student> list){
        System.out.println("test01");
    }

    public Map<String,Student> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) {
        try {
            System.out.println("======================================");
            //获得指定方法参数泛型类型
            Method m = GenericDemo.class.getMethod("test01", Map.class, List.class);
            Type [] t = m.getGenericParameterTypes();
            for (Type paramType:t){
                System.out.println("#"+paramType);
                if (paramType instanceof ParameterizedType){
                    Type [] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                    for (Type genericType:genericTypes){
                        System.out.println("泛型类型："+genericType);
                    }
                }
            }
            System.out.println("======================================");
            //获得指定方法返回值泛型信息
            Method m2 = GenericDemo.class.getMethod("test02");
            Type  t1 = m2.getGenericReturnType();
            Type [] genericTypes = ((ParameterizedType) t1).getActualTypeArguments();
            for (Type genericType:genericTypes){
                System.out.println("泛型类型："+genericType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
