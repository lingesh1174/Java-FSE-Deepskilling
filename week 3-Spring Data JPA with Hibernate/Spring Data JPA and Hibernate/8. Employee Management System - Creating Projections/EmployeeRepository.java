package com.cognizant.employee.repository;

import com.cognizant.employee.model.*;
import com.cognizant.employee.projection.EmployeeSummary;
import com.cognizant.employee.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByEmailEndingWith(String domain);

    List<Employee> findByNameContainingIgnoreCase(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %?1%")
    List<Employee> searchByEmailKeyword(String keyword);

    @Query("SELECT new com.cognizant.employee.dto.EmployeeDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeDTO> fetchEmployeeDTO();

    @Query("SELECT e.name AS name, e.email AS email FROM Employee e")
    List<EmployeeSummary> fetchEmployeeSummary();
}

