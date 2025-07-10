package com.cognizant.employee.controller;

import com.cognizant.employee.dto.EmployeeDTO;
import com.cognizant.employee.projection.EmployeeSummary;
import com.cognizant.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-projections")
public class EmployeeProjectionController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/dto")
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.fetchEmployeeDTO();
    }

    @GetMapping("/summary")
    public List<EmployeeSummary> getEmployeeSummaries() {
        return employeeRepository.fetchEmployeeSummary();
    }
}
