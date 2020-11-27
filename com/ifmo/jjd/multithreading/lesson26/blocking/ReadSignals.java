package com.ifmo.jjd.multithreading.lesson26.blocking;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class ReadSignals implements Runnable{

    private ArrayBlockingQueue<Signal> signals;

    public ReadSignals(ArrayBlockingQueue<Signal> signals) {
        this.signals = Objects.requireNonNull(signals);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(" ReadSignals " + Thread.currentThread());
            try {
                System.out.println("Signal " + signals.take() +" took from queue");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
