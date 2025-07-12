package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    private List<Department> departmentList;

    public DepartmentDao(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }

    public Department getDepartmentById(Integer id) {
        for (Department dept : departmentList) {
            if (dept.getId().equals(id)) {
                return dept;
            }
        }
        throw new RuntimeException("Department with id " + id + " not found");
    }
}
