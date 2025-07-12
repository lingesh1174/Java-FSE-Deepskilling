package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class EmployeeDao {
    public static ArrayList<Employee> EMPLOYEE_LIST;

    @Autowired
    public EmployeeDao(ArrayList<Employee> employeeList) {
        EMPLOYEE_LIST = employeeList;
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}