package com.ifmo.jjd.lesson19.iohomework;

import java.io.*;

public class IOService {

    public static void writeToFile(String data, String fileName) throws IOException {
        File file = new File(fileName);
        byte[] bytes = data.getBytes();
        try (CoderToFile outputStream = new CoderToFile(new FileOutputStream(file))) {
            outputStream.write(bytes);
        }
    }

    public static String readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] bytes = new byte[100];
        int data;
        String result = null;
        try (DecoderFromFile inputStream = new DecoderFromFile(new FileInputStream(file));
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()
        ) {
            while ((data = inputStream.read(bytes)) != -1) {
                byteArray.write(bytes, 0, data);
            }
            byteArray.toByteArray();
            result = new String(byteArray.toByteArray());
        }
        /*try (FileInputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream bytesArray = new ByteArrayOutputStream()
        ) {
            while ((data = inputStream.read(bytes)) != -1) {
                bytesArray.write(bytes, 0, data);
            }
            byte[] key = KeyForCoding.KEY.toString().getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte)(bytes[i] ^ key[i % key.length]);
            }
            result = new String(bytesArray.toByteArray());
        }*/
        return result;
    }
}
