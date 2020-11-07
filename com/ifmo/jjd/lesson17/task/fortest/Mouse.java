package com.ifmo.jjd.lesson17.task.fortest;

import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredClass;
import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredField;
import com.ifmo.jjd.lesson17.task.fortest.config.MouseConfig;

@RequiredClass
public class Mouse {
    @RequiredField
    private MouseConfig mouseConfig;
    private String name;
    private int speed;

    public Mouse() {
        name = mouseConfig.getMouseName();
        speed = mouseConfig.getMouseSpeed();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
