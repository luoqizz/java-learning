package com.brianway.learning.java.base.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * IO 字符流读
 */
public class TestFileReader {
    public static void main(String[] args) {
        int b = 0;
        FileReader r = null;

        try {
            int num = 0;
            r = new FileReader("D:\\myclass\\Student.java");
            while ((b = r.read()) != -1){
                num++;
                System.out.println(b);
            }
            r.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
