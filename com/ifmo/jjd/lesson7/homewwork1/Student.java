package com.ifmo.jjd.lesson7.homewwork1;

public class Student
        extends LearningHuman
        implements Study {

    private int knowledge;
    private boolean learnInThisDay;

    public Student(String name, int age, String subject, int knowledge) {
        super(name, age, subject);
        this.knowledge = knowledge;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public boolean isLearnInThisDay() {
        return learnInThisDay;
    }

    public void setLearnInThisDay(boolean learnInThisDay) {
        this.learnInThisDay = learnInThisDay;
    }

    public void study(int study) {
        if (study <= 0) throw new IllegalArgumentException("study <= 0");
        this.knowledge += study;
    }

    public String getInfoShort() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                "knowledge=" + knowledge +
                '}';
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                "knowledge=" + knowledge +
                '}';
    }
}
