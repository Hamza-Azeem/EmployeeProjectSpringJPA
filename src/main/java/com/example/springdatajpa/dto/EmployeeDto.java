package com.example.springdatajpa.dto;

import com.example.springdatajpa.entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

public class EmployeeDto {

    private Long id;
    private String name;
    private Double salary;
    private Department department;

    public EmployeeDto(){};
    public EmployeeDto(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
