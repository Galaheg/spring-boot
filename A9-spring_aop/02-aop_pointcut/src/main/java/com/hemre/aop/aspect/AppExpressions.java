package com.hemre.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AppExpressions {

    @Pointcut("execution(public * add*(com.hemre.aop.Account, ..))")
    public void forDaoPackage(){}

    @Pointcut("execution(public * com.hemre.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(public * com.hemre.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
