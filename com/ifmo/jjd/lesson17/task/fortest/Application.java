package com.ifmo.jjd.lesson17.task.fortest;

import com.ifmo.jjd.lesson17.task.dicontainer.DIContainer;
import com.ifmo.jjd.lesson17.task.fortest.config.CatConfig;
import com.ifmo.jjd.lesson17.task.fortest.config.MouseConfig;
import com.ifmo.jjd.lesson17.task.fortest.config.OwnerConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<Class> classes = new HashSet<>();
        List container = new ArrayList();
        classes.add(Cat.class);
        classes.add(Mouse.class);
        classes.add(Owner.class);
        classes.add(CatConfig.class);
        classes.add(MouseConfig.class);
        classes.add(OwnerConfig.class);

        DIContainer diContainer = null;
        try {
            diContainer = new DIContainer(classes);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Cat cat = diContainer.getObject("cat");
        Mouse mouse = diContainer.getObject("mouse");
        cat.catchMouse(mouse);
    }
}
