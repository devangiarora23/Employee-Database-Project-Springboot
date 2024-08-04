package com.myproject.cruddemo.service;

import com.myproject.cruddemo.DAO.EmployeeRepository;
import com.myproject.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository theEmployeeRepository)
    {
        employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findbyId(int theId)
    {
        Optional<Employee> byId = employeeRepository.findById(theId);
        return byId;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void delete(int theId) {
        employeeRepository.deleteById(theId);
    }
}
