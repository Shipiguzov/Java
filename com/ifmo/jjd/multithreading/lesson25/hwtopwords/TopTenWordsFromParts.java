package com.ifmo.jjd.multithreading.lesson25.hwtopwords;

import java.util.ArrayList;
import java.util.Map;

public class TopTenWordsFromParts {
    public static void main(String[] args) {

        String filePath = "sourses/farm.txt";
        ProcessingText text = new ProcessingText(filePath);

        text.getTextFromFile();
        //System.out.println(text.getMap() + "\n\n");
        ArrayList<Thread> threadArrayList = new ArrayList<>();
        // создание Runnable для потоков с описанием интерфейса run()
        Runnable runTop = () -> {
            System.out.println(Thread.currentThread());
            text.processingTextPart(text.getPartMap());
            System.out.println(Thread.currentThread().getName() + " finish work");
        };
        // добавление потоков в коллекцию
        for (int i = 0; i < 6; i++) {
            threadArrayList.add(new Thread(runTop));
        }
        // запуск потоков из коллекции
        for (Thread thread : threadArrayList) {
            thread.start();
        }
        // основной поток ждёт, пока отработают все потоки
        for (Thread thread : threadArrayList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        text.sortingResultMap(10);
        System.out.println(text.getResult());

        //System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
