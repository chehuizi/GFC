package com.bmf.dev.annotations;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DomainEvent {

    /**
     * 领域事件编码
     * @return
     */
    int eventCode();

    /**
     * 领域事件别名（英文）
     * @return
     */
    String eventAlias();
}
