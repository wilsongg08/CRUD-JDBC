package com.ejemplo.crudoperation.controller;

import com.ejemplo.crudoperation.model.Employee;
import com.ejemplo.crudoperation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired  //Inyectamos la dependencia
    private EmployeeRepository employeeRepository;

    @PostMapping("/save") //Ok
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        try{
            employeeRepository.save(new Employee(employee.getName(), employee.getSalary()));
            return new ResponseEntity<>("Employee was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Fatal error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/select") //Ok
    public ResponseEntity<List<Employee>> getAllEmployees(){

        try{
            List<Employee> list = new ArrayList<Employee>();
            employeeRepository.findAll().forEach(list::add);

            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{eid}") //Ok
    public ResponseEntity<String> deleteEmployee(@PathVariable("eid") int id){
        try{
            int result = employeeRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Employee with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Employee was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete Employee.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTutorial(@PathVariable("id") int id, @RequestBody Employee employee) {
        Employee _employee = employeeRepository.findById(id);

        if (_employee != null) {
            _employee.setId(id);
            _employee.setName(employee.getName());
            _employee.setSalary(employee.getSalary());

            employeeRepository.update(_employee);
            return new ResponseEntity<>("Employee was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Employee with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
}
