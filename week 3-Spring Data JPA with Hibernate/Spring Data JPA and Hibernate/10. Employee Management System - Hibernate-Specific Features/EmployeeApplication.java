package com.cognizant.employee;

import com.cognizant.employee.model.Department;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.repository.DepartmentRepository;
import com.cognizant.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void run(String... args) throws Exception {
        Department dept = new Department();
        dept.setName("Finance");
        departmentRepository.save(dept);

        for (int i = 1; i <= 100; i++) {
            Employee emp = new Employee();
            emp.setName("Employee " + i);
            emp.setEmail("emp" + i + "@example.com");
            emp.setDepartment(dept);
            employeeRepository.save(emp);

            if (i % 20 == 0) {
                employeeRepository.flush();
            }
        }

        System.out.println("Batch insertion of 100 employees completed.");
    }
}

