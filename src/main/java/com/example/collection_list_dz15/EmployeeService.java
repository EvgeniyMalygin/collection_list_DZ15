package com.example.collection_list_dz15;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private static List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Петров", "Иван"),
            new Employee("Иванов", "Иван"),
            new Employee("Сидоров", "Петр"),
            new Employee("Сергеев", "Демид"),
            new Employee("Терновский", "Олег"),
            new Employee("Мимиков", "Федор"),
            new Employee("Демидов", "Ринат"),
            new Employee("Черкасов", "Николай"),
            new Employee("Козлов", "Олег"),
            new Employee("Ястребов", "Дмитрий")
    ));

    @Override
    public Employee addEmploy(String fistName, String lastName) {
        Employee tempEmploee = new Employee(lastName, fistName);
        if (employeeList.contains(tempEmploee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(tempEmploee);
        return tempEmploee;
    }

    @Override
    public Employee removeEmploy(String fistName, String lastName) {
        Employee tempEmploy = new Employee(lastName, fistName);
        findEmploy(fistName, lastName);
        if (employeeList.contains(tempEmploy)) {
            employeeList.remove(tempEmploy);
            return tempEmploy;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmploy(String fistName, String lastName) {
        Employee tempEmploy = new Employee(lastName, fistName);
        if (employeeList.contains(tempEmploy)) {
            return tempEmploy;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> printAllEmployees() {
        return Collections.unmodifiableList(employeeList);
    }

}
