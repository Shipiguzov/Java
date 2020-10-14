package com.ifmo.jjd.lesson7.homewwork1;

public class LearningHuman extends Human{
    protected String subject;

    public LearningHuman(String name, int age, String subject) {
        super(name, age);
        setSubject(subject);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        subject.trim();
        if (subject == null || subject.length() < 2) throw new IllegalArgumentException("subject 2 or more characters");
        this.subject = subject;
    }
}
