package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainEventPO extends BasePO {

    /**
     * 事件编码
     */
    private Integer eventCode;
    /**
     * 事件名称
     */
    private String eventName;
    /**
     * 事件描述
     */
    private String eventDesc;

}
