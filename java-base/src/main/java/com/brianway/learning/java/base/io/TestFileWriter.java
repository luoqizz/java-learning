package com.brianway.learning.java.base.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void main(String[] args) {
        int b = 0;
        FileReader r = null;
        FileWriter w = null;
        try {
            int num = 0;
            r = new FileReader("D:\\myclass\\Student.java");
            w = new FileWriter("D:\\myclass\\Student022.java");
            while ((b = r.read()) != -1){
                w.write(b);
                num++;
                System.out.println(b);
            }
            r.close();
            w.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
