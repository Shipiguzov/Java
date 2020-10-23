package com.ifmo.jjd.school;

public class Teacher extends Human implements TeachAble{
    private String subject;
    // private int subjectLevel;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void teach(LearnAble student) {
        student.learn();
    }

    public String getSubject() {
        return subject;
    }
}
