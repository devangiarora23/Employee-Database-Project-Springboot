package com.myproject.cruddemo.service;

import com.myproject.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findbyId(int theId);

    Employee save(Employee theEmployee);

    void delete(int theId);

}
