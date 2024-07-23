package com.hemre.springboot.cruddemo.service;


import com.hemre.springboot.cruddemo.dao.EmployeeRepository;
import com.hemre.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(){

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo){
        employeeRepo = theEmployeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepo.findById(id); // for null control

        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find Employee id - " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
}
