package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.projection.CountProjection;
import com.example.springdatajpa.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Query("SELECT employee FROM Employee employee WHERE employee.name like :name")
    List<Employee> filterByName(@Param("name") String name);
    List<Employee> findEmployeeByDepartmentId(long id);
    @Query("SELECT emp from Employee emp join emp.department dept where dept.id =:id")
    List<Employee> findByDepartment(long id);
    @Query(value = "SELECT (SELECT count(id) FROM employee) empCount," +
            " (SELECT count(id) FROM department) deptCount", nativeQuery = true)
    CountProjection findCountInEntities();

    @Query("SELECT emp FROM Employee emp WHERE emp.salary >= :salary")
    Page<EmployeeProjection> filterBySalary(double salary, Pageable pageable);

};
