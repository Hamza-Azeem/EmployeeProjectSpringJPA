package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.EmployeeDto;
import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll(){
        return employeeService.findAllEmployees();
    }
    @GetMapping("/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id") long id){
        return employeeService.findEmployee(id);
    }
    @GetMapping("/filterBy/{name}")
    public List<Employee> filterByName(@PathVariable("name") String name){
        return employeeService.filterEmployeesByName(name);
    }
    @PostMapping("")
    public Employee save(@RequestBody Employee employee){
        return employeeService.insertEmployee(employee);
    }
    @PutMapping("")
    public Employee update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
    }
    @GetMapping("/department/{id}")
    public List<Employee> findEmployeesByDepartment(@PathVariable long id){
        return employeeService.findEmployeesInDepartment(id);
    }
    @GetMapping("/count/stat")
    public ResponseEntity<?> findCountStatInEntities(){
        return new ResponseEntity<>(employeeService.findCountInAllEntities(), HttpStatus.OK);
    }
    @GetMapping("/filter/{salary}")
    public ResponseEntity<?> filterBySalaryAndSort(@PathVariable("salary") double salary,
                                                   @RequestParam int pageNum, @RequestParam int pageSize,
                                                   @RequestParam boolean isAsc, @RequestParam String colName){
        return ResponseEntity.ok(employeeService.filterEmployeesBySalary(
                salary, pageNum, pageSize, colName, isAsc
        ));
    }
}
