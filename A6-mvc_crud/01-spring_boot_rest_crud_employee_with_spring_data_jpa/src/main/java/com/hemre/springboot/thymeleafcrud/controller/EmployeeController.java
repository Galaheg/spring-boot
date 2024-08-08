package com.hemre.springboot.thymeleafcrud.controller;

import com.hemre.springboot.thymeleafcrud.entity.Employee;
import com.hemre.springboot.thymeleafcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

   private EmployeeService employeeService;

   @Autowired
   public EmployeeController(EmployeeService employeeService){
       this.employeeService=employeeService;
   }

   @GetMapping("/list")
    public String listEmployees(Model theModel){
        // get from db
       List<Employee> theEmployees = employeeService.findAll();

       System.out.println(theEmployees);
       theModel.addAttribute("employees", theEmployees);

       return "list-employees";
       // add to model
   }
}
