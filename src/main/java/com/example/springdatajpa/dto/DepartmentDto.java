package com.example.springdatajpa.dto;

import com.example.springdatajpa.entity.Employee;
import jakarta.persistence.*;

import java.util.List;

public class DepartmentDto {

    private long id;
    private String name;
    private List<Employee> employees;

    public DepartmentDto(){};

    public DepartmentDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
