package com.cognizant.employee.secondary.repository;

import com.cognizant.employee.secondary.model.ArchiveEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveEmployeeRepository extends JpaRepository<ArchiveEmployee, Integer> {
}
