package com.example.collection_list_dz15;

import java.util.Collection;
import java.util.List;

public interface EmployeeServiceInterface {

    Employee addEmploy(String fistName, String lastName, double salary, int department);

    Employee removeEmploy(String fistName, String lastName);

    Employee findEmploy(String fistName, String lastName);

    Collection<Employee> printAllEmployees();

    Collection<Employee> minSalaryInDepartment(int numberDepartment);

    Collection<Employee> maxSalaryInDepartment(int number);


    Collection<Employee> printEmployeeInDepartment(int number);
}
