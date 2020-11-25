package com.ifmo.jjd.multithreading.lesson24;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DaemonAndInterrupting {
    public static void main(String[] args) {

        // Daemon потоки
        Thread daemon = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(5000);
                    Files.write(Paths.get("sources/daemon.txt"),
                            "Daemon поток...\n".getBytes(),
                            StandardOpenOption.APPEND);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        daemon.setDaemon(true); // поток завершит работу, когда завершат
        // работу все не daemon потоки
        daemon.start();

        /*try {
            daemon.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // Прерывание потока
        // Поток остановится, если:
        // 1. выполнил свои инструкции
        // 2. было выброшено необработанное исключение
        // 3. остановилась JVM
        // 4. если поток был daemon потоком и все не daemon потоки
        // завершили свою работу

        Thread actions = new Thread(()->{
            // true -> !true -> false : while(false){}
            // false -> !false -> true : while(true){}
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Some actions...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { // при перехвате InterruptedException статус сбрасывается
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });

        actions.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.interrupt();

    }
}
