package com.hemre.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

@Aspect
@Component
public class LoggingAspect {

    //@Before("execution(public void addAccount())") // parametresi pointcut adını alır(execution pointcut)
    //@Before("execution(public void com.hemre.aop.dao.AccountDAO.addAccount())") // spesifik addaccount fonksiyonu
    //@Before("execution(public void add*())") // add ile naşlayan tüm fonskyionlar
    @Before("execution(public * add*())") // tüm return type ve add ile başlayanlar
    public void beforeAddAccount(){
        System.out.println("Before add*");
    }

}
