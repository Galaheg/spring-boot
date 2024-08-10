package com.hemre.springboot.thymeleafcrud.controller;

import com.hemre.springboot.thymeleafcrud.entity.Employee;
import com.hemre.springboot.thymeleafcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

       return "employees/list-employees";
       // add to model
   }

   @GetMapping("/showFormForAdd")
   public String showFormForAdd(Model theModel){
      Employee theEmployee = new Employee();

      theModel.addAttribute("employee", theEmployee);

      return "employees/employee-form";
   }

   @PostMapping("/save")
   public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
      employeeService.save(theEmployee);
      return "redirect:/employees/list";
   }

   @GetMapping("/showFormForUpdate")
   public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

      Employee theEmployee = employeeService.findById(theId);
      theModel.addAttribute("employee", theEmployee);

      return "employees/employee-form";
   }
   @GetMapping("/showFormForDelete")
   public String showFormForDelete(@RequestParam("employeeId") int theId, Model theModel) {

      employeeService.deleteById(theId);

      return "redirect:/employees/list";
   }

}
