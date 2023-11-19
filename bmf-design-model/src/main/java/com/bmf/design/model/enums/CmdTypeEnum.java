package com.bmf.design.model.enums;

import lombok.Getter;

/**
 * CMD类型枚举
 */
@Getter
public enum CmdTypeEnum {

    INSERT("insert", "插入"),
    UPDATE("update", "更新"),
    DELETE("delete", "删除"),
    ;

    /**
     * CMD指令
     */
    private String type;
    /**
     * 指令描述
     */
    private String desc;

    CmdTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
