package com.bmf.design.model.enums;

import lombok.Getter;

/**
 * 快照对象类型枚举
 */
@Getter
public enum SnapshotObjTypeEnum {

    DOMAIN_STRATEGY("domain_strategy", "领域战略设计"),
    ;

    /**
     * 快照对象类型
     */
    private String objType;
    /**
     * 快照对象类型描述
     */
    private String objTypeDesc;

    SnapshotObjTypeEnum(String objType, String objTypeDesc) {
        this.objType = objType;
        this.objTypeDesc = objTypeDesc;
    }

}
