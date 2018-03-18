package com.brianway.learning.java.base.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 缓冲流。
 * 类似在文件流上套一层 能使用比文件流更强大的API 不用一个字节一个字节的去读取文件
 */
public class TestBufferStream1 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\myclass\\Student.java");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int c = 0;
            System.out.println(bis.read());
            bis.mark(100);
            for (int i = 0 ; i<=10 && (c = bis.read()) != -1 ; i++){
                System.out.println(c);
            }
            System.out.println("===============");
            bis.reset();
            for (int i = 0 ; i<=10 && (c = bis.read()) != -1 ; i++){
                System.out.println(c);
            }
            bis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
