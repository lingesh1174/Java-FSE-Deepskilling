package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }
}
