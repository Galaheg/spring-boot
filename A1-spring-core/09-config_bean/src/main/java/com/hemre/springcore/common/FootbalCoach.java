package com.hemre.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class FootbalCoach implements Coach{

    public FootbalCoach() {
        System.out.println("Constructor of: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise Legs for your Strength :-)";
    }
}
