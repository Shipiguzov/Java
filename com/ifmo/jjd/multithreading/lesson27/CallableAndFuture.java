package com.ifmo.jjd.multithreading.lesson27;

import com.ifmo.jjd.multithreading.lesson26.blocking.Signal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService signalService = Executors.newFixedThreadPool(3);
        Callable<Signal> signalGenerator = new SignalGenerator();

        ArrayList<Future<Signal>> signalContainers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // метод submit (вместо execute) - передает задачу в очередь и ждёт, пока вернется что-либо
            // объект Future - контейнер, в который будет добавлен результат работы потока
            Future<Signal> container = signalService.submit(signalGenerator);
            signalContainers.add(container);
        }
        /*for (Future<Signal> container : signalContainers) {
            System.out.println("Waiting future...");
            try {
                System.out.println("Signal: " + container.get()); // приостанавливает текущий (на бесконечное время) поток при пустом контейнере, пока объект не появится
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        signalService.shutdown();*/
        for (Future<Signal> container : signalContainers) {
            System.out.println("Waiting future...");
            try {
                System.out.println("Signal: " + container.get((long) (Math.random() * 1000), TimeUnit.MILLISECONDS)); // приостанавливает текущий (на бесконечное время) поток при пустом контейнере, пока объект не появится
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Can't wait for generated signal in container");
            }
        }
        signalService.shutdown();

        List<Callable<Signal>> tasksList = new ArrayList<>();
        Callable<Signal> callable = () -> {
            Thread.sleep((long) (Math.random() * 3000));
            Signal signal = Signal.getSignal();
            System.out.println("New signal: " + signal);
            return signal;
        };

        tasksList.add(callable);
        tasksList.add(callable);
        tasksList.add(callable);
        tasksList.add(callable);

        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            List<Future<Signal>> futureList = service.invokeAll(tasksList);
            service.shutdown();

            for (Future<Signal> container : futureList) {
                System.out.println("SIGNAL: " + container.get());
            }
        } catch (InterruptedException |
                ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class SignalGenerator implements Callable<Signal> {
    // Callable - альтернатива Runnable, но поток вернет указанный объект (инструкции потока)
    @Override
    public Signal call() throws Exception {
        Thread.sleep((long) (Math.random() * 3000));
        Signal signal = Signal.getSignal();
        System.out.println("Object " + signal + " generated");
        return signal;
    }
}
