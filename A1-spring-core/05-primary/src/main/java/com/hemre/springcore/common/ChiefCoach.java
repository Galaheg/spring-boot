package com.hemre.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ChiefCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I'am Chief Coach, GO RUN 5 KM";
    }
}
