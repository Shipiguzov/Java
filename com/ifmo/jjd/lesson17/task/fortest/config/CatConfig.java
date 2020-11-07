package com.ifmo.jjd.lesson17.task.fortest.config;

import com.ifmo.jjd.lesson17.task.dicontainer.marks.ConfigClass;

@ConfigClass(file = "app.config", prefix = "cat")
public class CatConfig {
    private String catName;
    private int catSpeed;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatSpeed() {
        return catSpeed;
    }

    public void setCatSpeed(int catSpeed) {
        this.catSpeed = catSpeed;
    }
}
