package com.cognizant.employee;

import com.cognizant.employee.controller.*;
import com.cognizant.employee.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private DepartmentController departmentController;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Department dept = new Department();
        dept.setName("Engineering");
        Department savedDept = departmentController.createDepartment(dept);
        System.out.println("Saved Department: " + savedDept);

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setEmail("john.doe@example.com");
        emp.setDepartment(savedDept);
        Employee savedEmp = employeeController.createEmployee(emp);
        System.out.println("Saved Employee: " + savedEmp);

        System.out.println("All Employees:");
        employeeController.getAllEmployees().forEach(System.out::println);
    }
}