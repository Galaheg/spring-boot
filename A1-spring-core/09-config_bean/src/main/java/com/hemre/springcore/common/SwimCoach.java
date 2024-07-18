package com.hemre.springcore.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("Constructor of swimCoach: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim deeper";
    }
}
