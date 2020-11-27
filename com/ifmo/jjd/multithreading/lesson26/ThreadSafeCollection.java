package com.ifmo.jjd.multithreading.lesson26;

import com.ifmo.jjd.multithreading.lesson26.blocking.ReadSignals;
import com.ifmo.jjd.multithreading.lesson26.blocking.Signal;
import com.ifmo.jjd.multithreading.lesson26.blocking.Task;
import com.ifmo.jjd.multithreading.lesson26.blocking.WriteSignals;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadSafeCollection {
    public static void main(String[] args) {
        // Vector, HashTable, Stack
        // коллекция и мапа блокируются полностью (при Vector, HashTable, Stack и в Collections.synchronized...
        // однопоточные коллекции и мапы в многопоточные
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        // Вместо перечисленных выше лучше использовать перечисленные в concurrent.md

        LinkedBlockingQueue<String> strings = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Integer> integers = new LinkedBlockingQueue<>(23);

        ArrayBlockingQueue<Signal> signals = new ArrayBlockingQueue<>(20, true);

        /*new Thread(new WriteSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();
        new Thread(new WriteSignals(signals)).start();*/

        // если объект будет добавлен в DelayQueue, то класс этих объектов должен имплементировать интерфейс Delayed
        DelayQueue<Task> tasks = new DelayQueue<>();
        tasks.put(new Task(LocalDateTime.now().minusDays(1), () -> {
            System.out.println("OLD");
        }));
        tasks.put(new Task(LocalDateTime.now().plusSeconds(10), () -> {
            System.out.println("Current");
        }));
        tasks.put(new Task(LocalDateTime.now().plusMinutes(1), () -> {
            System.out.println("Future");
        }));
        while (true) {
            try {
                new Thread(tasks.take().getAction()).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
