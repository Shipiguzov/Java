package com.ifmo.jjd.lesson17.task.fortest;

import com.ifmo.jjd.lesson17.task.fortest.config.CatConfig;
import com.ifmo.jjd.lesson17.task.fortest.config.MouseConfig;
import com.ifmo.jjd.lesson17.task.fortest.config.OwnerConfig;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<Class> classes = new HashSet<>();
        classes.add(Cat.class);
        classes.add(Mouse.class);
        classes.add(Owner.class);
        classes.add(CatConfig.class);
        classes.add(MouseConfig.class);
        classes.add(OwnerConfig.class);

        // TODO:: инициализация DI контейнера и тд
    }
}
