package com.ifmo.jjd.lesson17.task.fortest;

import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredClass;
import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredField;
import com.ifmo.jjd.lesson17.task.fortest.config.CatConfig;

import java.util.ArrayList;

@RequiredClass
public class Cat {
    @RequiredField
    private CatConfig catConfig;
    private String name;
    private int speed;

    @RequiredField
    private Owner owner;

    private ArrayList<Mouse> mice = new ArrayList<>(20);

    public Cat() {
        name = catConfig.getCatName();
        speed = catConfig.getCatSpeed();
    }

    public void catchMouse(Mouse mouse) {
        if (speed < mouse.getSpeed()) {
            System.out.println(mouse.getName() + " убежал от " + name);
            return;
        }
        mice.add(mouse);
        System.out.println(name + " поймал " + mouse.getName());

    }

}
