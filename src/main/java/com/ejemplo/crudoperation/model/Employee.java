package com.ejemplo.crudoperation.model;

import java.util.Objects;

// @Entity  son anotaciones del JPA, utilizando JdbcTemplate no los reconoce o no son utiles
// @Table(name = "employee")
public class Employee {
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Constructor adicional necesario
    public Employee( String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && Double.compare(employee.getSalary(), getSalary()) == 0 && Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSalary());
    }
}
