package com.ifmo.jjd.lesson15.hw.employee;// Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int salary, int age) {
        this.setName(name);
        this.setCompany(company);
        this.setSalary(salary);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) throw new IllegalArgumentException("Name must be more 3 chars");
        this.name = name;
    }

    public void setCompany(String company) {
        if (company == null || company.length() < 3) throw new IllegalArgumentException("Company must be more 3 chars");
        this.company = company;
    }

    public void setSalary(int salary) {
        if (salary <= 0) throw new IllegalArgumentException("Salayr must be more 0");
        this.salary = salary;
    }

    public void setAge(int age) {
        if (age < 21 || age > 60) throw new IllegalArgumentException("Age must be more 14 and less 60");
        this.age = age;
    }

    private int randomNumber(int minRange, int maxRange) {
        return (int) (Math.random() * (maxRange - minRange + 1) + minRange);
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(
                    names[(int) (Math.random() * 11)],
                    companies[(int) (Math.random() * 6)],
                    (int) (Math.random() * (1000 - 200 + 1) + 200),
                    (int) (Math.random() * (60 - 21 + 1) + 21))
        );
        }
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (salary != employee.salary) return false;
        if (age != employee.age) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return company != null ? company.equals(employee.company) : employee.company == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}

/*
class NameComparatorEmployeers implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}*/
