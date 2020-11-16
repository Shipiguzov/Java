package com.ifmo.jjd.lesson17.task.fortest;

import com.ifmo.jjd.lesson17.task.dicontainer.DIContainer;
import com.ifmo.jjd.lesson17.task.fortest.config.CatConfig;
import com.ifmo.jjd.lesson17.task.fortest.config.MouseConfig;
import com.ifmo.jjd.lesson17.task.fortest.config.OwnerConfig;

import java.lang.reflect.InvocationTargetException;
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

        DIContainer diContainer = new DIContainer(classes);
        try {
            diContainer.run();
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
