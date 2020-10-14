package com.ifmo.jjd.lesson7.homewwork1;

public class Teacher
        extends LearningHuman
        implements Teach {

    private int teachPower;
    private int knowledge;

    public Teacher(String name, int age, String subject, int knowledge, int teachPower) {
        super(name, age, subject);
        setTeachPower(teachPower);
        setKnowledge(knowledge);
    }

    public void setTeachPower(int teachPower) {
        if (teachPower < 0) throw new IllegalArgumentException("teachPower < 0");
        this.teachPower = teachPower;
    }

    public void setKnowledge(int knowledge) {
        if (knowledge < 5) throw new IllegalArgumentException("knowledge of teacher < 5");
        this.knowledge = knowledge;
    }

    public void teach(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            if (student[i] == null) throw new IllegalArgumentException("student == null");
            if (!student[i].isLearnInThisDay() && this.subject == student[i].subject && this.knowledge > student[i].getKnowledge()) {
                if (student[i].getKnowledge() + this.teachPower < this.knowledge) {
                    student[i].study(this.teachPower);
                } else student[i].study(this.knowledge - student[i].getKnowledge());
                student[i].setLearnInThisDay(true);
            }

        }
    }
}
