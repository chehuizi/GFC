package com.bmf.infrastructure.dal.po;

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
}
