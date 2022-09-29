package com.example.collection_list_dz15;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {

        this.departmentService = departmentService;
    }


    @GetMapping("/departments/min-salary")
    public Employee minSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.minSalaryInDepartment(departmentId);
    }

    @GetMapping("/departments/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.maxSalaryInDepartment(departmentId);
    }

    @GetMapping("/departments/all")
    public Object printEmployeeInDepartment(Integer departmentId) {
        if (departmentId != null){
            return departmentService.printEmployeeInDepartment(departmentId);
        }else return departmentService.printEmployeeInDepartment();
    }

}
