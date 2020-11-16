package com.ifmo.jjd.lesson17.task.fortest;

import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredClass;
import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredField;
import com.ifmo.jjd.lesson17.task.fortest.config.MouseConfig;

import java.util.Random;

@RequiredClass
public class Mouse {
    @RequiredField
    private MouseConfig mouseConfig;
    private String name;
    private int speed;

    public Mouse() {
        /*name = mouseConfig.getMouseName();
        speed = mouseConfig.getMouseSpeed();*/
    }

    public String getName() {
        return name;
    }

    public void setName() {
        //this.name = name;
        this.name = mouseConfig.getMouseName();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed() {
        Random temp = new Random();
        this.speed = temp.nextInt(mouseConfig.getMouseSpeed());
    }

    public void setMouseConfig(MouseConfig mouseConfig) {
        this.mouseConfig = mouseConfig;
    }
}
