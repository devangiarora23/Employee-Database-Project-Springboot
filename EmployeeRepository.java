package com.myproject.cruddemo.DAO;

import com.myproject.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //public List<Employee> findAllByOrderByLast_NameAsc();

}
