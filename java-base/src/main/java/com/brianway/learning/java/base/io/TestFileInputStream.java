package com.brianway.learning.java.base.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * JAVA_IO
 * FileInputStream 读字节流
 */
public class TestFileInputStream {
    public static void main(String[] args) {
        int b = 0;
        FileInputStream in = null;

        try {
            long num = 0;
            in = new FileInputStream("D:\\myclass\\Student.java");

            while ((b = in.read()) != -1){
                System.out.println((char)b);
                num ++;
            }
            in.close();
            System.out.println("=================");
            System.out.println("共读取了"+num+"个字节");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("读取文件错误");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
