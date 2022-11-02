package com.ejemplo.crudoperation.repository;

import com.ejemplo.crudoperation.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCEmployeeRepository implements EmployeeRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employee (name, salary) VALUES(?,?)",
                new Object[]{employee.getName(),employee.getSalary()});
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * from employee", BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
    }
    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE employee SET name=?, salary=? WHERE id=?",
                new Object[] { employee.getName(), employee.getSalary(), employee.getId()});
    }

    @Override
    public Employee findById(int id) {
        try {
            Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Employee.class), id);

            return employee;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
