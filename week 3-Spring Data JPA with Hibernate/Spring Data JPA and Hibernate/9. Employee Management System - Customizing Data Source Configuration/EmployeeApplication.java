package com.cognizant.employee;

import com.cognizant.employee.model.Department;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.repository.DepartmentRepository;
import com.cognizant.employee.repository.EmployeeRepository;
import com.cognizant.employee.secondary.model.ArchiveEmployee;
import com.cognizant.employee.secondary.repository.ArchiveEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class EmployeeApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ArchiveEmployeeRepository archiveEmployeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Department dept = new Department();
        dept.setName("Engineering");
        departmentRepository.save(dept);

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setEmail("john.doe@example.com");
        emp.setDepartment(dept);
        employeeRepository.save(emp);

        ArchiveEmployee archive = new ArchiveEmployee("John Doe");
        archiveEmployeeRepository.save(archive);

        System.out.println("Primary DB: " + employeeRepository.findAll());
        System.out.println("Secondary DB: " + archiveEmployeeRepository.findAll());
    }
}
