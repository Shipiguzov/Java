package com.ifmo.jjd.lesson19.iohomework;

import java.io.File;
import java.io.IOException;

public class IOApp {
    public static void main(String[] args) {
        String text = "Hello, mother fucker";
        String fileName = "E:\\Java\\com\\ifmo\\jjd\\lesson19\\iohomework\\text.txt";
        try {
            IOService.writeToFile(text, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(IOService.readFromFile(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
