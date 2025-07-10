package com.cognizant.employee.dto;

public class EmployeeDTO {
    private String name;
    private String departmentName;

    public EmployeeDTO(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{name='" + name + "', departmentName='" + departmentName + "'}";
    }
}
