package com.hemre.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Hop ball for 40 minutes";
    }
}
