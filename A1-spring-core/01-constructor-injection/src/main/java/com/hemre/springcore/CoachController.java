package com.hemre.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coach")
public class CoachController {
    private Coach myCoach;

    @Autowired
    public CoachController(Coach coach){
        myCoach = coach;
    }

    @GetMapping("/football")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
