package com.ifmo.jjd.lesson7.homewwork1;

final public class Director extends Human {

    private boolean stoplesson = true;

    public Director(String name, int age) {
        super(name, age);
    }

    public void startLesson(Teacher[] teachersList, Student[] studentsList) {
        for (int i = 0; i < teachersList.length; i++) {
            teachersList[i].teach(studentsList);
        }
    }


    public boolean isStoplesson() {
        return stoplesson;
    }

    public void setStoplesson(boolean stoplesson, Student[] studentslist) {
        for (int i = 0; i < studentslist.length; i++) {
            studentslist[i].setLearnInThisDay(false);
        }
        this.stoplesson = stoplesson;
    }

    public void stopLesson() {
        this.stoplesson = true;
    }
}
