package com.brianway.learning.java.base.io;

import java.io.*;

/**
 * 缓冲流
 */
public class TestBufferStearm2 {

    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\myclass\\text.txt"));
            BufferedReader br = new BufferedReader(new FileReader("D:\\myclass\\text.txt"));

            String s = null;
            for (int i = 1 ; i <= 100 ; i++){
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();

            }
            bw.flush();


            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
            bw.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
