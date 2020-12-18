package com.ifmo.jjd.exam2;

import java.io.*;
import java.util.concurrent.Exchanger;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger implements Runnable {

    private LinkedBlockingQueue<String> stringForLog;

    public Logger(LinkedBlockingQueue<String> stringForLog) {
        this.stringForLog = stringForLog;
    }

    @Override
    public void run() {
        File file = new File("sourses/log.txt");
        try (OutputStream outputStream = new FileOutputStream(file)) {
            while (true) {
                String stringToWrite = stringForLog.take();
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}