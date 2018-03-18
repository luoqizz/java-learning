package com.brianway.learning.java.base.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestTransForm1 {
    public static void main(String[] args) {

        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(
                    new FileOutputStream("D:\\myclass\\text.txt"));
            osw.write("madfasdfasdfasfsadfsaf");
            System.out.println(osw.getEncoding());
            osw = new OutputStreamWriter(
                    new FileOutputStream("D:\\myclass\\text.txt",true),"ISO8859_1");
            osw.write("jsklfjasdklfjlkasjfdksljfkla");
            System.out.println(osw.getEncoding());
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
