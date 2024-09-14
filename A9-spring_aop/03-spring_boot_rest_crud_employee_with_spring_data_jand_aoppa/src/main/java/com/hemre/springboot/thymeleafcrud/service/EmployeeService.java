package com.hemre.springboot.thymeleafcrud.service;

import com.hemre.springboot.thymeleafcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
