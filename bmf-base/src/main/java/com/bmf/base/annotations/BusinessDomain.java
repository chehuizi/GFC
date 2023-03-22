package com.bmf.base.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BusinessDomain {

    /**
     * 领域编码
     */
    int domainCode();
}
