package com.ifmo.jjd.school;

public class School {
    final private String name;
    private Director director;
    final private Teacher[] teachers = new Teacher[4];
    final private Student[] students = new Student[8];

    public School(String name, Director director) {
        this.name = name;
        this.director = director;
    }

    final public void passDay(){
        director.start();
        // iter
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                for (Student student : students) {
                    if (student != null && student.getSubject().equalsIgnoreCase(teacher.getSubject())){
                        teacher.teach(student);
                    }
                }
            }
        }
        director.finish();
    }

}
