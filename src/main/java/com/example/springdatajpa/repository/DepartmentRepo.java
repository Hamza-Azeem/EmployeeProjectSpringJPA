package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
