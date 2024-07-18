package com.hemre.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{

    public BasketballCoach() {
        System.out.println("Constructor of: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Hop ball for 40 minutes";
    }
}
