package com.brianway.learning.java.base.io;

import java.io.*;

public class TestObjectIO {
    public static void main(String[] args) throws Exception {
        T t = new T();
        t.k = 8;
        FileOutputStream fos = new FileOutputStream("D:\\myclass\\test.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("D:\\myclass\\test.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        T tReaded = (T) ois.readObject();
        System.out.println(tReaded.i + " " + tReaded.j + " " + tReaded.k + " " +tReaded.d);

    }
}

class T implements Serializable{
    int i = 0 ;
    int j = 9 ;
    double d = 2.3;
    int k = 0;
}
