package com.example.collection_list_dz15;

import java.util.Objects;

public class Employee {
    private String fistName;
    private String lastName;
    private double salary;
    private int department;

    public Employee(String lastName, String fistName, double salary, int department) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fistName + " " + lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fistName.equals(employee.fistName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
