package com.example.springdatajpa.projection;

import com.example.springdatajpa.entity.Department;
import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    long getId();

    String getName();
    double getSalary();
}
