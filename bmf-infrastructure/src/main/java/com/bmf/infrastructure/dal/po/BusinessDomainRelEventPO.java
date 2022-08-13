package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainRelEventPO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 事件编码
     */
    private Integer eventCode;

}
