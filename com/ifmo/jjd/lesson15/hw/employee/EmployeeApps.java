package com.ifmo.jjd.lesson15.hw.employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeApps {
    public static void main(String[] args) {

        List<Employee> employees;
        employees = Employee.employeeGenerator(10);
        System.out.println(employees);

        Comparator<Employee> comparatorEmployeers = new NameComparatorEmployeers();
        employees.sort(comparatorEmployeers);
        System.out.println("----Остортирован по именам----");
        System.out.println(employees);
        comparatorEmployeers = new NameComparatorEmployeers()
                .thenComparing(new SalaryComparatorEmployeers());
        employees.sort(comparatorEmployeers);
        System.out.println("----Отсортирован по имени и зарплате----");
        System.out.println(employees);
        comparatorEmployeers = new NameComparatorEmployeers()
                .thenComparing(new SalaryComparatorEmployeers()
                .thenComparing(new AgeComparatorEmployeers()
                .thenComparing(new CompanyComparatorEmployeers())));
        employees.sort(comparatorEmployeers);
        System.out.println("----Отсортирован по имени, зарплате, возврасту и компании----");
        System.out.println(employees);
    }
}
