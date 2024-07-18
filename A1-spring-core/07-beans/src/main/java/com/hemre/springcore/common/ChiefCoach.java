package com.hemre.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ChiefCoach implements Coach{

    public ChiefCoach() {
        System.out.println("Constructor of: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "I'am Chief Coach, GO RUN 5 KM";
    }
}
