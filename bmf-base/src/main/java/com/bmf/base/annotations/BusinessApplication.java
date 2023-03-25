package com.bmf.base.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BusinessApplication {

    /**
     * 领域编码
     */
    int domainCode();

    /**
     * 领域别名（英文）
     * @return
     */
    String domainAlias();
}
