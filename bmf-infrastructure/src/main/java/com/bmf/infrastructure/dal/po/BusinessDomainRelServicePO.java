package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainRelServicePO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 服务编码
     */
    private Integer serviceCode;

}
