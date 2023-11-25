package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessRelDomainPO extends BasePO {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 位置（JSON格式存储）
     */
    private String domainPosition;
}
