package com.bmf.common.aop;

import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import com.bmf.common.utils.ResultUtil;
import com.bmf.common.utils.SpringUtil;
import com.bmf.common.validator.Validator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * API拦截器
 */
@Aspect
@Component
@Order(1)
public class ApiAspect {

    @Pointcut(value = "execution(* com.bmf.api..*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
            Method method = signature.getMethod();
            Validator validator = method.getAnnotation(Validator.class);
            if (Objects.nonNull(validator)) {
                Object[] params = proceedingJoinPoint.getArgs();
                validate(validator, params);
            }
            return proceedingJoinPoint.proceed();
        } catch (BizException be) {
            return ResultUtil.fail(be.getCode(), be.getMessage());
        } catch (Exception ex) {
            return ResultUtil.fail(ex.getMessage());
        } catch (Throwable th) {
            return ResultUtil.fail(th.getMessage());
        }
    }

    /**
     * 执行校验器
     * @param validator
     * @param params
     */
    private void validate(Validator validator, Object[] params) {
        try {
            Class<? extends Object>[] paramsClass = null;
            if (Objects.nonNull(params)) {
                int paramsLength = params.length;
                paramsClass = new Class[paramsLength];
                for (int i=0; i<paramsLength; i++) {
                    paramsClass[i] = params[i].getClass();
                }
            }
            Object bean = SpringUtil.getBean(validator.beanName());
            String methodName = validator.method();
            Method method = ReflectionUtils.findMethod(bean.getClass(), methodName, paramsClass);
            method.invoke(bean, params);
        } catch (BizException be) {
            throw be;
        } catch (Exception ex) {
            throw new BizException(BizCodeEnum.VALIDATOR_ERROR);
        }
    }
}
