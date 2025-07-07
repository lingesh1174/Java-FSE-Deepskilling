package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("[AOP] Before method execution");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfterMethod() {
        System.out.println("[AOP] After method execution");
    }
}