package com.ifmo.jjd.multithreading.lesson26.blocking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {

    private final LocalDateTime time;
    private final Runnable action;

    public Task(LocalDateTime time, Runnable action) {
        this.time = Objects.requireNonNull(time);
        this.action = Objects.requireNonNull(action);
    }

    public Runnable getAction() {
        return action;
    }

    // если метод вернет 0 или отрицательное число, то такой элемент можно извлекать из очереди,
    // если положительное число, то поток будет заблокирован
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(
                Duration.between(LocalDateTime.now(), time).getSeconds(),
                TimeUnit.SECONDS
        );
    }

    @Override // определяет, как элементы в очереди будут отсортированы
    public int compareTo(Delayed o) {
        LocalDateTime otherTime = ((Task) o).time;
        return time.compareTo(otherTime);
    }
}
