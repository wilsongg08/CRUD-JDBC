package com.ejemplo.crudoperation.repository;

import com.ejemplo.crudoperation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository
public interface EmployeeRepository {
    int save(Employee employee);
    List<Employee> findAll();
    int deleteById(int id);
    Employee findById(int id);
    int update(Employee employee);

}
