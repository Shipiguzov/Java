package com.ifmo.jjd.multithreading.lesson25;

import com.ifmo.jjd.multithreading.lesson25.waitnotify.GetThread;
import com.ifmo.jjd.multithreading.lesson25.waitnotify.Library;
import com.ifmo.jjd.multithreading.lesson25.waitnotify.PutThread;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        SomeAccount account = new SomeAccount();

        ArrayList<IncrementTask> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new IncrementTask(account));
        }

        for (IncrementTask task : tasks) {
            task.start();
        }

        for (IncrementTask task : tasks) {
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // account 10 -> 20 - при одновременном изменении баланса двумя потоками часть данных не будет изменена
        // --- 10 + 10 = 20
        // --- 10 + 10 = 20

        System.out.println("Balance: " + account.getBalance());

        Library library = new Library();
        new Thread(new PutThread(library)).start();
        new Thread(new PutThread(library)).start();
        new Thread(new PutThread(library)).start();
        new Thread(new GetThread(library)).start();
    }
}
