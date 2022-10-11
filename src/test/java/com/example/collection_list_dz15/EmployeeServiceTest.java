package com.example.collection_list_dz15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.collection_list_dz15.EmployeeServiceTestConstance.*;

public class EmployeeServiceTest {

    public static EmployeeService out;

    @BeforeEach
    public void initOut() {
        out = new EmployeeService();
    }


    // Добавление корректного пользователя
    @Test
    void shouldAddEmployWithCorrectArguments() {
        Assertions.assertEquals(EMPLOYEE, out.addEmploy(FIST_NAME, LAST_NAME, SALARY, DEPARTMENT));
    }

    // Добавление уже существующего пользователя
    @Test
    void shouldAddEmployWithError() {
        out.addEmploy(FIST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmploy(FIST_NAME, LAST_NAME, SALARY, DEPARTMENT));
    }

    // Поиск существующего пользователя
    @Test
    void shouldFindEmployWithCorrectArguments() {
        out.addEmploy(FIST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        Employee actual = out.findEmploy(FIST_NAME, LAST_NAME);
        Assertions.assertEquals(EMPLOYEE, actual);
    }

    // Поиск отсутствуещего пользователя
    @Test
    void shouldFindEmployWithError() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmploy(FIST_NAME, LAST_NAME));
    }

    // Удаление существующего пользователя
    @Test
    void shouldRemoveEmployWithCorrectArguments() {
        out.addEmploy(FIST_NAME, LAST_NAME, SALARY, DEPARTMENT);
        Employee actual = out.removeEmploy(FIST_NAME, LAST_NAME);
        Assertions.assertEquals(EMPLOYEE, actual);
    }

    // Удаление отсутствуещего пользователя
    @Test
    void shouldRemoveEmployWithError() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.removeEmploy(FIST_NAME, LAST_NAME));
    }

}
