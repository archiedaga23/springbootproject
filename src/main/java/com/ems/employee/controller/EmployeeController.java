package com.ems.employee.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.employee.model.Employee;
import com.ems.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> hello() {
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.saveAndFlush(new Employee(employee.getEmail(), employee.getFull_name(), employee.getContact_number()));
    }

    @DeleteMapping("{id}")
    public Long deleteEmployeeById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return id;
    }

    @PatchMapping()
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
