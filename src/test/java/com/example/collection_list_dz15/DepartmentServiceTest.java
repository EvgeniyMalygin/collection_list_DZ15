package com.example.collection_list_dz15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.collection_list_dz15.EmployeeServiceTestConstance.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;

    private DepartmentService out;

    @BeforeEach
    void setUp() {
        out = new DepartmentService(employeeServiceMock);
    }

    @Test
    void minSalaryInDepartmentTest() {
        List<Employee> tempList = new ArrayList<>(List.of(EMPLOYEE, EMPLOYEE1, EMPLOYEE2, EMPLOYEE3));
      when(employeeServiceMock.returnAll()).thenReturn(Collections.unmodifiableCollection(tempList));
        Assertions.assertEquals(EMPLOYEE1, out.minSalaryInDepartment(DEPARTMENT));
    }

    @Test
    void maxSalaryInDepartment() {
        List<Employee> tempList = new ArrayList<>(List.of(EMPLOYEE, EMPLOYEE1, EMPLOYEE2, EMPLOYEE3));
        when(employeeServiceMock.returnAll()).thenReturn(Collections.unmodifiableCollection(tempList));
        Assertions.assertEquals(EMPLOYEE, out.maxSalaryInDepartment(DEPARTMENT));
    }

    @Test
    void printEmployeeInDepartment() {
        List<Employee> tempList = new ArrayList<>(List.of(EMPLOYEE, EMPLOYEE1, EMPLOYEE2, EMPLOYEE3));
        List<Employee> expected = new ArrayList<>(List.of(EMPLOYEE, EMPLOYEE1, EMPLOYEE2));
        when(employeeServiceMock.returnAll()).thenReturn(Collections.unmodifiableCollection(tempList));
        Assertions.assertEquals(expected, out.printEmployeeInDepartment(DEPARTMENT));
    }

    @Test
    void testPrintEmployeeInDepartment() {
        Map<String, Employee> tempList = new HashMap<>();
        tempList.put(EMPLOYEE.getFullName(), EMPLOYEE);
        tempList.put(EMPLOYEE1.getFullName(), EMPLOYEE1);
        tempList.put(EMPLOYEE2.getFullName(), EMPLOYEE2);
        tempList.put(EMPLOYEE3.getFullName(), EMPLOYEE3);

        Map<String, Employee> expected = new HashMap<>();
        expected.put(EMPLOYEE.getFullName(), EMPLOYEE);
        expected.put(EMPLOYEE1.getFullName(), EMPLOYEE1);
        expected.put(EMPLOYEE2.getFullName(), EMPLOYEE2);
        expected.put(EMPLOYEE3.getFullName(), EMPLOYEE3);

        when(employeeServiceMock.returnAll()).thenReturn(tempList.values());
        Assertions.assertEquals(expected.values()
                        .stream().collect(Collectors.groupingBy(Employee::getDepartment)),
                out.printEmployeeInDepartment());
    }
}