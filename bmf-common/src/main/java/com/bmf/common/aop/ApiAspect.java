package com.bmf.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * API拦截器
 */
@Aspect
@Component
public class ApiAspect {

    @Pointcut(value = "execution(* com.bmf.api..*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) {
        String text = "";
        return null;
    }
}
