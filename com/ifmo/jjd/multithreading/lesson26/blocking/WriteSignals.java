package com.ifmo.jjd.multithreading.lesson26.blocking;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class WriteSignals implements Runnable{

    private ArrayBlockingQueue<Signal> signals;

    public WriteSignals(ArrayBlockingQueue<Signal> signals) {
        this.signals = Objects.requireNonNull(signals);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("WriteSignals: " + Thread.currentThread());
            Signal signal = Signal.getSignal();
            try {
                // если очередь переполнена, то поток будет заблокирован
                signals.put(signal);
                System.out.println("Signal " + signal + " puted in queue");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
