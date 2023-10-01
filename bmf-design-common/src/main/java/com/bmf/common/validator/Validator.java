package com.bmf.common.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validator {

    /**
     * beanId
     * @return
     */
    String beanName();

    /**
     * 方法名
     * @return
     */
    String method();
}
