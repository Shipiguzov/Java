package com.ifmo.jjd.lesson22;

import com.ifmo.jjd.lesson15.hw.employee.Employee;
import com.ifmo.jjd.lesson20.socketio.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class LambdaTraining {
    public static void main(String[] args) {
        /*Predicate<Client> isIPLocal = a -> a.getIp().startsWith("127");
        Client client = new Client("127.0.0.1", 8090);
        System.out.println(isIPLocal.test(client));
        Predicate<University> listOfCourseMore5 = a -> a.getCourses().size() >= 5;*/
        University university = new University();
        for (int i = 0; i < 3; i++) {
            university.addCourse(Course.getInstance());
        }
        /*System.out.println(listOfCourseMore5.test(university));
        Predicate<Double> sqrtIsInteger = a -> Math.sqrt(a) - (int)Math.sqrt(a) == 0;
        System.out.println("sqrt 5 is Integer: " + sqrtIsInteger.test(5.0));*/

        Predicate<Course> cost = course -> !(course.getPrice() < 20000);
        Function<University, Integer> courseCostMore20000 = a -> a.filtered(cost.negate()).size();
        System.out.println(courseCostMore20000.apply(university));
        System.out.println(university.getCourses());
        Function<University, Integer> numberOfJJDCourses = a -> {
            Integer count = 0;
            for (Course s : a.getCourses()) {
                if ("JJD".equalsIgnoreCase(s.getName())) count++;
            }
            return count;
        };
        System.out.println(numberOfJJDCourses.apply(university));

        UnaryOperator<List<Employee>> isFromApple = a -> {
            List<Employee> newList = new ArrayList<>();
            newList.addAll(a);
            Predicate<Employee> isCompanyApple = b -> !("google".equalsIgnoreCase(b.getCompany()));
            newList.removeIf(isCompanyApple);
            return newList;
        };
        List<Employee> employees = Employee.employeeGenerator(10);
        System.out.println("\n" + employees);
        System.out.println(isFromApple.apply(employees));
        UnaryOperator<String> doubleText = a -> a.toUpperCase() + a.toLowerCase();
        System.out.println(doubleText.apply("Some text example"));

    }
}
