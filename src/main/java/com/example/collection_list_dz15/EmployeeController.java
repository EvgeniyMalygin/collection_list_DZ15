package com.example.collection_list_dz15;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping
    public Collection<Employee> printAllEmployees() {

        return employeeService.printAllEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName,
                                @RequestParam("salary") double salary, @RequestParam("department") int department) {
        return employeeService.addEmploy(fistName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmploy(fistName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmploy(fistName, lastName);
    }

    @GetMapping("/departments/min-salary")
    public Collection<Employee> minSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.minSalaryInDepartment(departmentId);
    }

    @GetMapping("/departments/max-salary")
    public Collection<Employee> maxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.maxSalaryInDepartment(departmentId);
    }

    @GetMapping("/departments/all")
    public Collection<Employee> printEmployeeInDepartment(@RequestParam("departmentId") int departmentId) {
        return employeeService.printEmployeeInDepartment(departmentId);
    }

    @GetMapping("/departments/all1")
    public List<Employee> printAllEmployeeForDepartment() {
        return employeeService.printAllForDepartment();
    }
}
