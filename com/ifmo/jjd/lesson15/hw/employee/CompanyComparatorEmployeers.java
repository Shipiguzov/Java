package com.ifmo.jjd.lesson15.hw.employee;

import java.util.Comparator;

public class CompanyComparatorEmployeers implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}
