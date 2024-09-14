package com.hemre.springboot.thymeleafcrud.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class EmployeeLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.hemre.springboot.thymeleafcrud.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.hemre.springboot.thymeleafcrud.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.hemre.springboot.thymeleafcrud.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        String theMethod = joinPoint.getSignature().toShortString();

        myLogger.info("=========> in @Before: " + theMethod);

        Object[] args = joinPoint.getArgs();

        for (Object tempArgs : args){
            myLogger.info("=======> argument: " + tempArgs);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint joinPoint, Object theResult){

        String theMethod = joinPoint.getSignature().toShortString();

        myLogger.info("=========> in @AfterReturning: " + theMethod);

        myLogger.info("=========> result is after return: " + theResult);
    }
}
