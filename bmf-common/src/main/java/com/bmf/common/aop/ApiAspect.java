package com.bmf.common.aop;

import com.bmf.common.exception.BizException;
import com.bmf.common.utils.ResultUtil;
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
        try {
            return proceedingJoinPoint.proceed();
        } catch (BizException be) {
            return ResultUtil.fail(be.getCode(), be.getMessage());
        } catch (Exception ex) {
            return ResultUtil.fail(ex.getMessage());
        } catch (Throwable th) {
            return ResultUtil.fail(th.getMessage());
        }
    }
}
