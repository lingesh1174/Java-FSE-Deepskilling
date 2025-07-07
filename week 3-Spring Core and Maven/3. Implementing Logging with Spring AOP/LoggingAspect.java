package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Starting method: " + joinPoint.getSignature());

        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;
        System.out.println("Completed: " + joinPoint.getSignature() + " in " + duration + " ms");

        return result;
    }
}