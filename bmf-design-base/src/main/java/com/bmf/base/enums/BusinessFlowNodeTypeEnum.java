package com.bmf.base.enums;

import lombok.Getter;

/**
 * 业务流程节点类型枚举
 */
@Getter
public enum BusinessFlowNodeTypeEnum {

    START("start", "起始节点"),
    DOMAIN("domain", "领域节点"),
    PLAIN("plain", "普通节点"),
    END("end", "结束节点"),
    ;

    /**
     * 类型
     */
    private String type;
    /**
     * 类型描述
     */
    private String desc;

    BusinessFlowNodeTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
