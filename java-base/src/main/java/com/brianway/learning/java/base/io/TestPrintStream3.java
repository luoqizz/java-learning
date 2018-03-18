package com.brianway.learning.java.base.io;

import java.io.*;
import java.util.Date;

public class TestPrintStream3 {
    public static void main(String[] args) {
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileWriter fw = new FileWriter("d:\\myclass\\test.log",true);
            PrintWriter log = new PrintWriter(fw);

            while ((s = br.readLine())!= null){
                if (s.equalsIgnoreCase("exit")) break;
                System.out.println("------------------");
                log.println(s.toUpperCase());
                log.flush();
            }

            log.println("====="+new Date()+"===");
            log.flush();
            log.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
