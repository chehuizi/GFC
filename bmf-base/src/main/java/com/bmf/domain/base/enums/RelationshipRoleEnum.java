package com.bmf.domain.base.enums;

import lombok.Getter;

/**
 * 业务域关系角色枚举
 */
@Getter
public enum RelationshipRoleEnum {

    PL("PL", "发布语言"),
    OHS("OHS", "开放主机服务"),
    ACL("ACL", "防腐层"),
    CF("CF", "遵从者"),
    CUSTOMER("CUSTOMER", "客户"),
    SUPPLIER("SUPPLIER", "供应商"),
    KERNEL("KERNEL", "被包含"),
    SHELL("SHELL", "包含"),
    ;

    /**
     * 关系角色
     */
    private String role;
    /**
     * 关系角色描述
     */
    private String desc;

    RelationshipRoleEnum(String role, String desc) {
        this.role = role;
        this.desc = desc;
    }

}
