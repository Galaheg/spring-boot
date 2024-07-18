package com.hemre.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Use racket for 1 hour";
    }
}
