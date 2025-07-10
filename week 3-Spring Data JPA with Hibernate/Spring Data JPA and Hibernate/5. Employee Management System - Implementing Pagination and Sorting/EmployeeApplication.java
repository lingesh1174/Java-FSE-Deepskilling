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
        // Existing department and employee creation
        Department dept = new Department();
        dept.setName("Engineering");
        Department savedDept = departmentController.createDepartment(dept);

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setEmail("john.doe@example.com");
        emp.setDepartment(savedDept);
        employeeController.createEmployee(emp);

        System.out.println("Find by Name:");
        employeeRepository.findByName("John Doe").forEach(System.out::println);

        System.out.println("Find by Email Ending With '@example.com':");
        employeeRepository.findByEmailEndingWith("@example.com").forEach(System.out::println);

        System.out.println("Search by Keyword in Email:");
        employeeRepository.searchByEmailKeyword("doe").forEach(System.out::println);

        System.out.println("Named Query - Find by Dept Name:");
        employeeRepository.findByDeptNamed("Engineering").forEach(System.out::println);
    }
}