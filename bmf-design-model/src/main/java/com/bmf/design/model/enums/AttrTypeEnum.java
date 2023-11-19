package com.bmf.design.model.enums;

import lombok.Getter;

/**
 * 值对象类型枚举
 */
@Getter
public enum AttrTypeEnum {

    STRING("string", "字符串"),
    TIMESTAMP("timestamp", "时间戳"),
    INTEGER("integer", "整数"),
    DOUBLE("double", "浮点数"),
    BOOLEAN("boolean", "布尔类型"),
    ENUM("enum", "枚举"),
    ;

    /**
     * 类型
     */
    private String type;
    /**
     * 类型描述
     */
    private String desc;

    AttrTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
