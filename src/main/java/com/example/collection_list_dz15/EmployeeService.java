package com.example.collection_list_dz15;

import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    public Map<String, Employee> employeeList;


    public EmployeeService() {

        this.employeeList = new HashMap<>();
    }

    //Добавление сотрудника
    @Override
    public Employee addEmploy(String fistName, String lastName, double salary, int department) {
        validateInput(fistName, lastName);
        Employee tempEmploee = new Employee(lastName, fistName, salary, department);
        if (employeeList.containsKey(tempEmploee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.put(tempEmploee.getFullName(), tempEmploee);
        return tempEmploee;
    }

    //Удаление сотрудника
    @Override
    public Employee removeEmploy(String fistName, String lastName) {
        validateInput(fistName, lastName);
        Employee tempEmploy = new Employee(lastName, fistName, 0, 0);
        if (employeeList.containsKey(tempEmploy.getFullName())) {
            return employeeList.remove(tempEmploy.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    //Поиск сотрудника
    @Override
    public Employee findEmploy(String fistName, String lastName) {
        validateInput(fistName, lastName);
        Employee tempEmploy = new Employee(lastName, fistName, 0, 0);
        if (employeeList.containsKey(tempEmploy.getFullName())) {
            return employeeList.get(tempEmploy.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    //Печать списка всех сотрудников
    @Override
    public Collection<Employee> printAllEmployees() {
        return Collections.unmodifiableCollection(employeeList.values());
    }

    private void validateInput(String fistName, String lastName) {
        if(!(isAlpha(fistName) && isAlpha(lastName))){
            throw new InvalidInputExeption();
        }
    }
    //Добавлен метод чтобы написать тесты Mockit
    public Collection<Employee> returnAll() {
        return employeeList.values();
    }
}
