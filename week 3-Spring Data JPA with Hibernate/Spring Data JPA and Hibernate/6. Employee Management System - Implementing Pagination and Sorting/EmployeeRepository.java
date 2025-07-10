package com.cognizant.employee.repository;

import com.cognizant.employee.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    List<Employee> findByDepartment(Department department);
    List<Employee> findByNameContainingIgnoreCase(String keyword);
    List<Employee> findByEmailEndingWith(String domain);

    Page<Employee> findAll(Pageable pageable);
}
