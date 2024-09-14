package com.hemre.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRest {

    @Value("${coach.name}")
    private String name;

    @GetMapping("/")
    public String hello(){
        return name;
    }

    @GetMapping("/work")
    public String workHard(){
        return "WORK HARDER MY FRIEND";
    }

}
