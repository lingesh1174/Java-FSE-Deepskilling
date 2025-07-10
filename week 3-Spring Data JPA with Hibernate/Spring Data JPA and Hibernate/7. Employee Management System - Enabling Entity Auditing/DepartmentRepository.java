package com.cognizant.employee.repository;

import com.cognizant.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	Department findByName(String name);
}
