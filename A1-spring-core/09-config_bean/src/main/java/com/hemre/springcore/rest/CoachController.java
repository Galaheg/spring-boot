package com.hemre.springcore.rest;

import com.hemre.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coach")
public class CoachController {
    private Coach myCoach;

    @Autowired
    public CoachController(@Qualifier("swimCoach") Coach coach) {
        System.out.println("Constructor of: " + getClass().getSimpleName());
        myCoach = coach;
    }

//    @GetMapping("/check")
//    public String check(){
//        return "Comparing beans(True->Singleton, False->Prototype): myCoach == anotherCoach --> " + (myCoach==anotherCoach);
//    }

    @GetMapping("/myCoach")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
