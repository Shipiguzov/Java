package com.ifmo.jjd.lesson17.task.fortest.config;

import com.ifmo.jjd.lesson17.task.dicontainer.marks.ConfigClass;

@ConfigClass(file = "app.config", prefix = "mouse")
public class MouseConfig {
    private String mouseName;
    private int mouseSpeed;

    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }

    public int getMouseSpeed() {
        return mouseSpeed;
    }

    public void setMouseSpeed(int mouseSpeed) {
        this.mouseSpeed = mouseSpeed;
    }
}
