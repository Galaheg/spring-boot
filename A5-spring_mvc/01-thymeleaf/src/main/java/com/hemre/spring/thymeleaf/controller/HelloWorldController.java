package com.hemre.spring.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String sendForm(){
        return "helloworld";
    }


//    @GetMapping("/letsShoutDude")
//    public String shoutDude(HttpServletRequest request, Model model){
//
//        String theName = request.getParameter("studentName");
//
//        theName = theName.toUpperCase();
//
//        String result = "YO! " + theName;
//
//        model.addAttribute("message", result);
//
//        return "helloworld";
//    }

    @PostMapping("/letsShoutDudeVol2")
    public String shoutDudeVol2(@RequestParam("studentName") String theName, Model model){

        theName = theName.toUpperCase();

        String result = "YO! " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }


}
