package com.bmf.design.model.tactics.event;

import com.bmf.common.model.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * 业务领域事件
 */
@Data
public class DomainEvent extends BaseModel {

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
    /**
     * 事件属性列表
     */
    private List<DomainEventAttr> eventAttrList;
}
