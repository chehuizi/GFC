package com.bmf.base.enums;

import lombok.Getter;

/**
 * 值对象类型枚举
 */
@Getter
public enum AttrTypeEnum {

    STRING("string", "字符串"),
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
