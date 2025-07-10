package com.cognizant.employee;

import com.cognizant.employee.model.Department;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.repository.DepartmentRepository;
import com.cognizant.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class EmployeeApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Department dept = new Department();
        dept.setName("Engineering");
        departmentRepository.save(dept);

        String[] names = {"John Doe", "Alice Smith", "Bob Johnson"};
        String[] emails = {"john@example.com", "alice@example.com", "bob@example.com"};

        for (int i = 0; i < names.length; i++) {
            Employee emp = new Employee();
            emp.setName(names[i]);
            emp.setEmail(emails[i]);
            emp.setDepartment(dept);
            employeeRepository.save(emp);
        }

        System.out.println("=== Class-based Projection ===");
        employeeRepository.fetchEmployeeDTO().forEach(System.out::println);

        System.out.println("\n=== Interface-based Projection ===");
        employeeRepository.fetchEmployeeSummary().forEach(e ->
            System.out.println("Name: " + e.getName() + ", Email: " + e.getEmail()));
    }
}