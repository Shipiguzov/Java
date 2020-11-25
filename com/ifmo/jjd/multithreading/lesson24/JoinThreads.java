package com.ifmo.jjd.multithreading.lesson24;

import com.ifmo.jjd.lesson22.Course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

public class JoinThreads {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> results =
                new CopyOnWriteArrayList<>();

        Thread task1 = new Thread(()->{
            System.out.println("Введите число");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            try {
                results.add(Integer.parseInt(reader.readLine()));
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        });

        Thread task2 = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            results.add(100);
            System.out.println("task2 обработал данные");
        });
        Thread task3 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            results.add(9000);
            System.out.println("task3 обработал данные");
        });

        task1.start();
        task2.start();
        task3.start();

        // нам необходимо, чтобы поток (в данном случае основной)
        // ждал завершения работы других потоков (task1 / task2 / task3)

        // join - вызывающий поток (в данном случае основной) ожидает, когда
        // указанные потоки (task1 / task2 / task3) присоединятся к нему

        try {
            task1.join(10000);
            task2.join();
            task3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() +
                " получил результаты: " + results);
    }
}
