package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.EmployeeDto;
import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.projection.CountProjection;
import com.example.springdatajpa.projection.EmployeeProjection;
import com.example.springdatajpa.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    @Autowired
    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }
    public EmployeeDto findEmployee(long id){
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = repo.findById(id).get();
        employeeDto.setId(id);
        employeeDto.setName(employee.getName());
        employeeDto.setSalary(employee.getSalary());
        return employeeDto;
    }
    public List<Employee> filterEmployeesByName(String name){
        return repo.filterByName(name);
    }
    public List<Employee> findAllEmployees(){
        return repo.findAll();
    }
    public Employee insertEmployee(Employee employee){
        return repo.save(employee);
    }
    public Employee updateEmployee(Employee employee){
        return repo.save(employee);
    }
    public void deleteEmployeeById(long id){
        repo.deleteById(id);
    }
    public List<Employee> findEmployeesInDepartment(long id){
        return repo.findByDepartment(id);
    }
    public CountProjection findCountInAllEntities(){
        return repo.findCountInEntities();
    }
    public Page<EmployeeProjection> filterEmployeesBySalary(double salary, int pageNum, int pageSize,
                                                            String colName, Boolean isAsc){
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(
                isAsc? Sort.Direction.ASC: Sort.Direction.DESC, colName)
        );
        return repo.filterBySalary(salary, pageable);
    }


}
