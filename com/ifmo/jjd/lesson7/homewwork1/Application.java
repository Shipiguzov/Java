package com.ifmo.jjd.lesson7.homewwork1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numberOfStudents;
        int numberOfTeachers;
        Director director = new Director("Константин Попов", 52);
        Teacher[] teacherList;
        Student[] studentsList;
        String[] subjects = {"Математика", "География", "История", "Литература"};
        School school;

        System.out.print("Enter number of students: ");
        numberOfStudents = input.nextInt();
        System.out.print("Enter number of teachers: ");
        numberOfTeachers = input.nextInt();
        studentsList = new Student[numberOfStudents];
        teacherList = new Teacher[numberOfTeachers];

        // Создание массива студентов
        for (int i = 0; i < studentsList.length; i++) {
            StringBuffer nameOfStudent = new StringBuffer();
            nameOfStudent = nameOfStudent.append("Иван Петров ").append(i);
            int ageOfStudent = (int) (Math.random() * 10) + 7;
            int knowledgeOfStudent = (int) (Math.random() * 3) - 2;
            int subjectsRandom = (int) (Math.random() * (subjects.length - 1));
            Student student = new Student(nameOfStudent.toString(), ageOfStudent, subjects[subjectsRandom], knowledgeOfStudent);
            studentsList[i] = student;
        }

        // Создание массива учителей
        for (int i = 0; i < teacherList.length; i++) {
            StringBuffer nameOfTeacher = new StringBuffer();
            nameOfTeacher = nameOfTeacher.append("Саша Белый ").append(i);
            int ageOfTeacher = (int) (Math.random() * 40) + 25;
            int knowledgeOfTeacher = (int) (Math.random() * 10) + 5;
            int subjectsRandom = (int) (Math.random() * (subjects.length - 1));
            int teachPower = (int) ((Math.random() * 3) + 1);
            Teacher teacher = new Teacher(nameOfTeacher.toString(), ageOfTeacher, subjects[subjectsRandom], knowledgeOfTeacher, teachPower);
            teacherList[i] = teacher;
        }

        school = new School(director, teacherList, studentsList);

        for (int i = 0; i < 5; i++) {
            int lessonsInDay = (int) (Math.random() * 3) + 3;
            school.dayInSchool(lessonsInDay);
        }
    }
}
