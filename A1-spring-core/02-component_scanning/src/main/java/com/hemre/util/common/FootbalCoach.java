package com.hemre.util.common;

import org.springframework.stereotype.Component;

@Component
public class FootbalCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practise Legs";
    }
}
