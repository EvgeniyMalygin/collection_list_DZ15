package com.example.collection_list_dz15;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee minSalaryInDepartment(int numberDepartment) {

        return employeeService.employeeList.values()
                .stream()
                .filter(e -> e.getDepartment() == numberDepartment)
                .min(Comparator.comparingDouble(employee -> employee.getSalary())).orElseThrow(EmployeeNotFoundException::new);
    }

    //Поиск сотрудника с максимальной зарплатой в отделе

    public Employee maxSalaryInDepartment(int number) {

        return employeeService.employeeList.values()
                .stream()
                .filter(e -> e.getDepartment() == number)
                .max(Comparator.comparingDouble(employee -> employee.getSalary())).orElseThrow(EmployeeNotFoundException::new);
    }

    //Печать списка сотрудников отдела
    public List<Employee> printEmployeeInDepartment(Integer number) {

        return employeeService.employeeList.values().stream().filter(e -> e.getDepartment() == number)
                .collect(Collectors.toUnmodifiableList());
    }

    //Печать списка всех сотрудников с группировкой по отделам
    public Map<Integer, List<Employee>> printEmployeeInDepartment() {
        return employeeService.employeeList.values().stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
    }

}
