package com.hemre.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("Constructor of: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Use racket for 1 hour";
    }
}
