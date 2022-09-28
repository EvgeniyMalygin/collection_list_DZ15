package com.example.collection_list_dz15;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final Map<String, Employee> employeeList;


    public EmployeeService() {
        this.employeeList = new HashMap<>();
    }

    //Добавление сотрудника
    @Override
    public Employee addEmploy(String fistName, String lastName, double salary, int department) {
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
        Employee tempEmploy = new Employee(lastName, fistName, 0, 0);
        if (employeeList.containsKey(tempEmploy.getFullName())) {
            return employeeList.remove(tempEmploy.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    //Поиск сотрудника
    @Override
    public Employee findEmploy(String fistName, String lastName) {
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

    //Поиск сотрудника с минимальной зарплатой в отделе
    @Override
    public Collection<Employee> minSalaryInDepartment(int numberDepartment) {

        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeeList.values()
                .stream()
                .filter(e -> e.getDepartment() == numberDepartment)
                .min(Comparator.comparingDouble(employee -> employee.getSalary())).stream()
                .collect(Collectors.toList());
    }

    //Поиск сотрудника с максимальной зарплатой в отделе
    @Override
    public Collection<Employee> maxSalaryInDepartment(int number) {
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeeList.values()
                .stream()
                .filter(e -> e.getDepartment() == number)
                .max(Comparator.comparingDouble(employee -> employee.getSalary())).stream()
                .collect(Collectors.toList());
    }

    @Override
    //Печать списка сотрудников отдела
    public Collection<Employee> printEmployeeInDepartment(int number) {
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeeList.values()
                .stream()
                .filter(e -> e.getDepartment() == number)
                .collect(Collectors.toList());
    }

    //Печать списка сотрудников отдела
    public List<Employee> printAllForDepartment() {
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        List<Employee> tempList = new ArrayList<>(employeeList.values());
        return tempList.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList());
    }
}
