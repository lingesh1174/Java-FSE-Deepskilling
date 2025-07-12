package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
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
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee with id " + id + " not found"));
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(updatedEmployee.getId())) {
                employeeList.set(i, updatedEmployee);
                return;
            }
        }
        throw new RuntimeException("Employee with id " + updatedEmployee.getId() + " not found");
    }

    public void deleteEmployee(Integer id) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
        throw new RuntimeException("Employee with id " + id + " not found");
    }
}
