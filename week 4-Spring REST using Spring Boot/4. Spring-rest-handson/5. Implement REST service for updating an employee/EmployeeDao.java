package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    private List<Employee> employeeList;

    public EmployeeDao(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(Integer id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        throw new RuntimeException("Employee with id " + id + " not found");
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee emp = employeeList.get(i);
            if (emp.getId().equals(updatedEmployee.getId())) {
                employeeList.set(i, updatedEmployee);
                return;
            }
        }
        throw new RuntimeException("Employee with id " + updatedEmployee.getId() + " not found");
    }
}
