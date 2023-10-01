package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class DomainEventPO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 事件编码
     */
    private Integer eventCode;
    /**
     * 事件别名（英文）
     */
    private String eventAlias;
    /**
     * 事件名称（中文）
     */
    private String eventName;
    /**
     * 事件描述
     */
    private String eventDesc;

}
