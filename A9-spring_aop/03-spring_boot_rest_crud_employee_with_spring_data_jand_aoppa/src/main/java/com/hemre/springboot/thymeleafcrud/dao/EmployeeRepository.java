package com.hemre.springboot.thymeleafcrud.dao;

import com.hemre.springboot.thymeleafcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {//entity type and primary key
    public List<Employee> findAllByOrderByLastNameAsc();
}
