package com.bmf.base.enums;

import lombok.Getter;

/**
 * 业务域类型枚举
 * 目前只支持三种业务域类型
 */
@Getter
public enum BusinessDomainTypeEnum {

    CORE("core", "核心域"),
    SUPPORTING("supporting", "支撑域"),
    GENERIC("generic", "通用域")
    ;

    /**
     * 域类型
     */
    private String type;
    /**
     * 域类型描述
     */
    private String desc;

    BusinessDomainTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
