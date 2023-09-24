package com.bmf.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DomainService {

    /**
     * 服务编码
     * @return
     */
    int serviceCode();

    /**
     * 领域服务别名（英文）
     * @return
     */
    String serviceAlias();
}
