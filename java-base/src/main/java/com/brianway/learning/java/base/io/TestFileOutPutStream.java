package com.brianway.learning.java.base.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读写数据
 */
public class TestFileOutPutStream {
    public static void main(String[] args) {
        int b = 0;
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("D:\\myclass\\Student.java");
            out = new FileOutputStream("D:\\myclass\\StudentOne.java");

            while ((b = in.read()) != -1){
                out.write(b);
            }
            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件已经复制！");

    }
}
