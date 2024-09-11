package com.hemre.aop.aspect;

import com.hemre.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import java.util.List;


@Aspect
@Component
@Order(-1)
public class LoggingAspect {


    @AfterReturning(
            pointcut = "execution(* com.hemre.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningAccountAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========> Executing @AfterReturn" +
                method);

        System.out.println("\n========> result is " +
                result);

    }


    //@Before("execution(public void addAccount())") // parametresi pointcut adını alır(execution pointcut)
    //@Before("execution(public void com.hemre.aop.dao.AccountDAO.addAccount())") // spesifik addaccount fonksiyonu
    //@Before("execution(public void add*())") // add ile naşlayan tüm fonskyionlar
    //@Before("execution(public * add*())") // tüm return type ve add ile başlayanlar
    //@Before("execution(public * com.hemre.aop.dao.*.*(..))") // dao altındaki tüm fonksiyonlar 0 veya birden fazla parametre içerenler dahil
    //@Before("execution(public * add*(com.hemre.aop.Account))") // ozel parametre tipi
    //@Before("execution(public * add*(com.hemre.aop.Account, ..))") // ozel parametre tipi ve diger parametreler

    @Before("com.hemre.aop.aspect.AppExpressions.forDaoPackageNoGetterSetter()") // ozel parametre tipi ve diger parametreler
    public void beforeAddAccount(JoinPoint theJoinPoint){
        System.out.println("\nExecuting @Before advice on method");
        MethodSignature methodSignature =(MethodSignature) theJoinPoint.getSignature();

        // display the method signature
        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object o :args){
            System.out.println(o);//prints hashcode
            if (o instanceof Account){
                Account theAccount = (Account) o;
                System.out.println(((Account) o).getName() + " " +
                        ((Account) o).getLevel());
            }
        }
    }
}
