package com.cognizant.employee.repository;

import com.cognizant.employee.model.Employee;
import com.cognizant.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    Employee findByEmail(String email);

    List<Employee> findByDepartment(Department department);

    List<Employee> findByNameContainingIgnoreCase(String keyword);

    List<Employee> findByEmailEndingWith(String domain);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:keyword%")
    List<Employee> searchByEmailKeyword(@Param("keyword") String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :name")
    List<Employee> getEmployeesByDepartmentName(@Param("name") String name);

    @Query(name = "Employee.findByName")
    List<Employee> findByNameNamed(@Param("name") String name);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDeptNamed(@Param("deptName") String deptName);
}