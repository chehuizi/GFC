package com.bmf.base.tactics.event;

import com.bmf.base.BaseModel;
import lombok.Data;

/**
 * 业务领域事件
 */
@Data
public class BusinessDomainEvent extends BaseModel {

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
