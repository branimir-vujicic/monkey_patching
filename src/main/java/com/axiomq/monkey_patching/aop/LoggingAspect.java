package com.axiomq.monkey_patching.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class LoggingAspect {

    @Before("execution(* com.axiomq.monkey_patching.services.MoneyConverterImpl.convertEURtoUSD(..))")
    public void beforeConvertEURtoUSD(JoinPoint joinPoint) {
        System.out.println("Before method AOP: " + joinPoint.getSignature()
                                                            .getName());
    }

    @After("execution(* com.axiomq.monkey_patching.services.MoneyConverterImpl.convertEURtoUSD(..))")
    public void afterConvertEURtoUSD(JoinPoint joinPoint) {
        System.out.println("After method  AOP: " + joinPoint.getSignature()
                                                            .getName());
    }

//    @Around("execution(* com.axiomq.monkey_patching.services.MoneyConverterImpl.convertEURtoUSD(..))")
//    public Object aroundConvertEURtoUSD(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before method AOP: " + joinPoint.getSignature().getName());
//
//        // Proceed with the actual method execution
//        Object result = joinPoint.proceed();
//
//
//        System.out.println("After method  AOP: " + joinPoint.getSignature().getName());
//
//        return result;
//    }
}
