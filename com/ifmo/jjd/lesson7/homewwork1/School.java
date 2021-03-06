package com.ifmo.jjd.lesson7.homewwork1;

public class School {
    private Teacher[] teacherList;
    private Student[] studentslist;
    Director director;

    public School(Director director, Teacher[] teacherList, Student[] studentslist) {
        this.teacherList = teacherList;
        this.studentslist = studentslist;
        this.setDirector(director);
    }

    public void setDirector(Director director) {
        if (director == null) throw new IllegalArgumentException("Школа должна иметь директора!");
        this.director = director;
    }

    public void dayInSchool(int lessons){
        if (!director.isStoplesson()) throw new IllegalArgumentException("director.Stoplesson is true");
            for (int i = 0; i < lessons; i++) {
                director.startLesson(this.teacherList, this.studentslist);
            }
        director.setStoplesson(true, this.studentslist);
        this.getStudent();
    }

    public void getStudent(){
        for (int i = 0; i < studentslist.length; i++) {
            System.out.println(studentslist[i].getInfoShort());
        }
    }
}
