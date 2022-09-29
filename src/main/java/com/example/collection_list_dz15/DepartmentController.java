package com.example.collection_list_dz15;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/employee/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {

        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.minSalaryInDepartment(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.maxSalaryInDepartment(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public Object printEmployeeInDepartment(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.printEmployeeInDepartment(departmentId);
    }

    @GetMapping("/all")
    public Object printEmployeeInDepartment() {
        return departmentService.printEmployeeInDepartment();
    }
}
