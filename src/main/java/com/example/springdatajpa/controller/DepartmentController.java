package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.DepartmentDto;
import com.example.springdatajpa.entity.Department;
import com.example.springdatajpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("")
    public List<Department> findAll(){
        return departmentService.findAllDepartments();
    }
    @GetMapping("/{id}")
    public DepartmentDto findDepartmentById(@PathVariable("id") long id){
        return departmentService.findDepartment(id);
    }
    @PostMapping("")
    public Department save(@RequestBody Department department){
        return departmentService.insertDepartment(department);
    }
    @PutMapping("")
    public Department update(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        departmentService.deleteDepartmentById(id);
    }
}
