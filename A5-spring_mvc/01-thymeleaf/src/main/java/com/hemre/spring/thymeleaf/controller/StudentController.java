package com.hemre.spring.thymeleaf.controller;

import com.hemre.spring.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/student")
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${langs}")
    private List<String> langs;

    @Value("${oses}")
    private List<String> OSes;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        Student theStudent = new Student();
        model.addAttribute("student", theStudent);
        model.addAttribute("countries", countries);
        model.addAttribute("langs", langs);
        model.addAttribute("OSes", OSes);
        return "student-form";
    }

    @PostMapping("processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName() + ' ' + theStudent.getCountry());

        return "student-confirmation";
    }

}
