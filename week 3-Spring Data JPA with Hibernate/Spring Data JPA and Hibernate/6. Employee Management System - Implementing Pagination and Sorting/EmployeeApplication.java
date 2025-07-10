package com.cognizant.employee;

import com.cognizant.employee.controller.*;
import com.cognizant.employee.model.*;
import com.cognizant.employee.repository.*;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Department dept = new Department();
        dept.setName("Engineering");
        Department savedDept = departmentController.createDepartment(dept);

        String[] names = {"John Doe", "Alice Smith", "Bob Johnson", "Charlie Brown", "David Williams"};
        String[] emails = {"john.doe@example.com", "alice.smith@example.com", "bob.johnson@example.com",
                           "charlie.brown@example.com", "david.williams@example.com"};

        for (int i = 0; i < names.length; i++) {
            Employee emp = new Employee();
            emp.setName(names[i]);
            emp.setEmail(emails[i]);
            emp.setDepartment(savedDept);
            employeeController.createEmployee(emp);
        }
    }
}