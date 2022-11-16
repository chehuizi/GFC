package com.bmf.common.aop;

import com.alibaba.fastjson.JSON;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * API拦截器
 */
@Aspect
@Component
@Order(1)
public class ApiAspect {

    private static final Logger logger = LoggerFactory.getLogger(ApiAspect.class);

    @Pointcut(value = "execution(* com.bmf.api.impl..*.*(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
            Method method = signature.getMethod();
            Validator validator = method.getAnnotation(Validator.class);
            Object[] params = proceedingJoinPoint.getArgs();
            Class<? extends Object>[] paramsClass = method.getParameterTypes();
            logger.info("api request : " + JSON.toJSONString(params));
            if (Objects.nonNull(validator)) {
                validate(validator, params, paramsClass);
            }
            Object result = proceedingJoinPoint.proceed();
            logger.info("api response : " + JSON.toJSONString(result));
            return result;
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
    private void validate(Validator validator, Object[] params, Class<? extends Object>[] paramsClass) throws Throwable {
        try {
            Object bean = SpringUtil.getBean(validator.beanName());
            String methodName = validator.method();
            Method method = ReflectionUtils.findMethod(bean.getClass(), methodName, paramsClass);
            if (Objects.isNull(method)) {
                throw new BizException(BizCodeEnum.VALIDATOR_METHOD_NOT_FOUND);
            }
            method.invoke(bean, params);
        } catch (BizException be) {
            throw be;
        } catch (InvocationTargetException ite) {
            throw ite.getTargetException();
        } catch (Exception ex) {
            throw new BizException(BizCodeEnum.VALIDATOR_ERROR);
        }
    }
}
