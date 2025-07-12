package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DepartmentDao {
    public static ArrayList<Department> DEPARTMENT_LIST;

    @Autowired
    public DepartmentDao(ArrayList<Department> departmentList) {
        DEPARTMENT_LIST = departmentList;
    }

    public ArrayList<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}