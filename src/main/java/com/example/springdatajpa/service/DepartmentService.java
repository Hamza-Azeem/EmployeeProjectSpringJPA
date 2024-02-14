package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.DepartmentDto;
import com.example.springdatajpa.entity.Department;
import com.example.springdatajpa.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }
    public DepartmentDto findDepartment(long id){
        DepartmentDto departmentDto = new DepartmentDto();
        Department department = departmentRepo.findById(id).get();
        departmentDto.setId(id);
        departmentDto.setName(department.getName());
        departmentDto.setEmployees(department.getEmployees());
        return departmentDto;
    }
    public List<Department> findAllDepartments(){
        return departmentRepo.findAll();
    }
    public Department insertDepartment(Department department){
        return departmentRepo.save(department);
    }
    public Department updateDepartment(Department department){
        return departmentRepo.save(department);
    }
    public void deleteDepartmentById(long id){
        departmentRepo.deleteById(id);
    }
}
