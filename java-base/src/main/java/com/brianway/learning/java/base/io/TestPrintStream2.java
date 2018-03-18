package com.brianway.learning.java.base.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class TestPrintStream2 {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        if (filename!=null){
            list(filename,System.out);
        }
    }

    private static void list(String f, PrintStream fs) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s = null;
        while ((s = br.readLine())!= null){
            fs.println(s);
        }
        br.close();
    }


}
