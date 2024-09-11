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
    //@Before("execution(public * add*())") // tüm return type ve add ile başlayanlar
    //@Before("execution(public * com.hemre.aop.dao.*.*(..))") // dao altındaki tüm fonksiyonlar 0 veya birden fazla parametre içerenler dahil
    //@Before("execution(public * add*(com.hemre.aop.Account))") // ozel parametre tipi
    @Before("execution(public * add*(com.hemre.aop.Account, ..))") // ozel parametre tipi ve diger parametreler
    public void beforeAddAccount(){
        System.out.println("Before add*");
    }

}
