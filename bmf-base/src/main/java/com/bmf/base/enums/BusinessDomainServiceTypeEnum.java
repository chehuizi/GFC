package com.bmf.base.enums;

import lombok.Getter;

/**
 * 领域服务类型枚举
 */
@Getter
public enum BusinessDomainServiceTypeEnum {

    ENTITY("entity", "实体服务"),
    AGGREGATE("aggregate", "聚合服务"),
    ;

    /**
     * 类型
     */
    private String type;
    /**
     * 类型描述
     */
    private String desc;

    BusinessDomainServiceTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
