package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.math.BigDecimal;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        //testGetEmployee();
        //testAddEmployee();
        testUpdateEmployee();
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setSalary(new BigDecimal(75000));
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());

        Department dept = departmentService.get(1);
        employee.setDepartment(dept);

        employeeService.save(employee);
        LOGGER.debug("Employee: {}", employee);

        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        Department newDept = departmentService.get(2);
        employee.setDepartment(newDept);

        employeeService.save(employee);
        LOGGER.debug("Updated Employee: {}", employee);

        LOGGER.info("End");
    }
}