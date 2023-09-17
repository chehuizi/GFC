package com.bmf.base.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DomainApp {

    /**
     * 应用ID
     * @return
     */
    int appId();

    /**
     * 应用名称
     * @return
     */
    String appName();

    /**
     * 应用描述
     * @return
     */
    String appDesc();

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
