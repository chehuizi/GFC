package com.bmf.base.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DomainService {

    int serviceCode();
}
