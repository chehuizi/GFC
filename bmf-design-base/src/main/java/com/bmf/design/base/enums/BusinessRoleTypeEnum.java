package com.bmf.design.base.enums;

import lombok.Getter;

/**
 * 值对象类型枚举
 */
@Getter
public enum BusinessRoleTypeEnum {

    MANAGER("manager", "管理者"),
    OPERATOR("operator", "操作者"),
    ;

    /**
     * 类型
     */
    private String type;
    /**
     * 类型描述
     */
    private String desc;

    BusinessRoleTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
