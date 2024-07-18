package com.hemre.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("Constructor of: "+getClass().getSimpleName());
    }

    @PostConstruct
    public void init(){
        System.out.println("This is INIT function "+getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("This is DESTROY function "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Use racket for 1 hour";
    }
}
