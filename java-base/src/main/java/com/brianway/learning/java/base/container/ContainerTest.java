package com.brianway.learning.java.base.container;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 容器
 */
public class ContainerTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("aaaa");
        c.add(123123);
        c.add(new User("呵呵"));
        System.out.println(c.size());
        System.out.println(c);

        System.out.println(c.remove(new User("呵呵")));

        System.out.println(c.size());
        System.out.println(c);
    }


}

class User{
    public User(String name) {
        this.name = name;
    }

    String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }

    //类的判断必须重写类的hashCode方法和equals方法

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User u = (User) obj;
            return (name.equals(u.name));
        }
        return super.equals(obj);
    }
}