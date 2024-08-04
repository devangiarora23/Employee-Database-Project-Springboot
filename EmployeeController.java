package com.myproject.cruddemo.controller;


import com.myproject.cruddemo.entity.Employee;
import com.myproject.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theemployeeservice) {
        employeeService = theemployeeservice;
    }


    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> theEmployee = employeeService.findAll();

        theModel.addAttribute("employee",theEmployee);

        return "employee-list.html";
    }

    @GetMapping("/showFormtoAdd")
    public String addEmployee(Model themodel){
        Employee employee=new Employee();
        themodel.addAttribute("employee", employee);
        return "employee-added.html";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list.html";
    }

    @GetMapping("/updateForm")
    public String updateEmployee(@RequestParam("employeeId") int id, Model theModel) {

        Optional<Employee> employee=employeeService.findbyId(id);
        theModel.addAttribute("employee", employee);
        return "employee-added.html";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.delete(id);
        return "redirect:/employees/list.html";
    }
}
