package com.example.collection_list_dz15;

import java.util.Collection;

public interface EmployeeServiceInterface {
    Employee addEmploy(String fistName, String lastName);

    Employee removeEmploy(String fistName, String lastName);

    Employee findEmploy(String fistName, String lastName);

    Collection<Employee> printAllEmployees();
}
