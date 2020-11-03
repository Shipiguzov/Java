package com.ifmo.jjd.lesson15.hw.employee;

import java.util.Comparator;

public class AgeComparatorEmployeers implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}
