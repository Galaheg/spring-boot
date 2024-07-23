package com.hemre.springboot.cruddemo.dao;

import com.hemre.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {//entity type and primary key

}
