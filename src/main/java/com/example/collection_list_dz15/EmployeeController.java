package com.example.collection_list_dz15;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
    public Employee addEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {
        return employeeService.addEmploy(fistName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {
        return employeeService.removeEmploy(fistName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("fistName") String fistName, @RequestParam("lastName") String lastName) {
       return employeeService.findEmploy(fistName, lastName);
    }
}
