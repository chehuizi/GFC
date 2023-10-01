package com.bmf.base.enums;

import lombok.Getter;

/**
 * 领域元素枚举
 */
@Getter
public enum DomainElementEnum {

    DOMAIN_SERVICE("domain_service", "领域服务"),
    DOMAIN_EVENT("domain_event", "领域事件"),
    NONE("none", "非领域元素"),
    ;

    /**
     * 领域元素
     */
    private String element;
    /**
     * 元素描述
     */
    private String desc;

    DomainElementEnum(String element, String desc) {
        this.element = element;
        this.desc = desc;
    }

}
