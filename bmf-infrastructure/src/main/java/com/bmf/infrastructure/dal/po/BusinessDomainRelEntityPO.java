package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainRelEntityPO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;

}
