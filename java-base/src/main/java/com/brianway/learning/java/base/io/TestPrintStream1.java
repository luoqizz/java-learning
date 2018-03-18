package com.brianway.learning.java.base.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestPrintStream1 {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("D:\\myclass\\text.txt");
            ps = new PrintStream(fos);

            if (ps != null){
                System.setOut(ps);
            }

            int ln = 0;
            for (char c = 0 ; c <= 6000 ; c++){
                System.out.println(c+" ");
                if (ln ++ >= 100 ){
                    System.out.println();
                    ln = 0;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
