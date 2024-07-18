package com.hemre.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class FootbalCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practise Legs for your Strength :-)";
    }
}
