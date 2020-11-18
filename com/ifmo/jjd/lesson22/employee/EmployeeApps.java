package com.ifmo.jjd.lesson22.employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeApps {
    public static void main(String[] args) {

        List<Employee> employees;
        employees = Employee.employeeGenerator(10);
        System.out.println(employees);

        employees.sort(Comparator.comparing(employee -> employee.getName()));
        System.out.println("----Остортирован по именам----");
        System.out.println(employees);
        employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        System.out.println("----Отсортирован по имени и зарплате----");
        System.out.println(employees);
        employees.sort(Comparator
                .comparing(Employee::getName)
                .thenComparing(Employee::getSalary)
                .thenComparing(Employee::getAge)
                .thenComparing(Employee::getCompany)
        );
        System.out.println("----Отсортирован по имени, зарплате, возврасту и компании----");
        System.out.println(employees);
    }
}
