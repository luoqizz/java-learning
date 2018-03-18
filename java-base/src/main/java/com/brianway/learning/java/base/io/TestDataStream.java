package com.brianway.learning.java.base.io;

import java.io.*;

public class TestDataStream {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        try {
            dos.write(123213);
            dos.writeBoolean(true);
            dos.writeDouble(Math.random());

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            System.out.println(bais.available());
            DataInputStream dis = new DataInputStream(bais);

            System.out.println(dis.read());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
            dos.close();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
