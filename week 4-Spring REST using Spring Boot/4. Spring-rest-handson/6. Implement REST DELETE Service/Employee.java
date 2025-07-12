package com.cognizant.spring_learn.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Employee {
    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    private Department department;

    @NotNull
    private List<Skill> skills;

    public Employee() {
    }

    public Employee(Integer id, String name, Department department, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.skills = skills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
