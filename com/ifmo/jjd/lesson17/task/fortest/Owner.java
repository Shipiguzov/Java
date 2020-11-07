package com.ifmo.jjd.lesson17.task.fortest;


import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredClass;
import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredField;
import com.ifmo.jjd.lesson17.task.fortest.config.OwnerConfig;

@RequiredClass
public class Owner {
    @RequiredField
    private OwnerConfig ownerConfig;
    private String name;

    public Owner() {
        this.name = ownerConfig.getOwnerName();
    }
}
