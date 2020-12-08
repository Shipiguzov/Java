package com.ifmo.jjd.exam2;

import java.io.*;
import java.util.concurrent.Exchanger;

public class Logger implements Runnable {

    Exchanger<String> loginString;

    @Override
    public void run() {
        File file = new File("sourses/log.txt");
        try (OutputStream inputStream = new FileOutputStream(file)) {
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        while (true) {

        }
    }
}