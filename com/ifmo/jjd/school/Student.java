package com.ifmo.jjd.school;

public class Student extends Human implements LearnAble{
    private String subject;
    private int level;

    public Student(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void learn() {
        this.level++;
    }

    public String getSubject() {
        return subject;
    }
}
