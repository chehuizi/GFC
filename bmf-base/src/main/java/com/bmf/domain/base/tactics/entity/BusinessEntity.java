package com.bmf.domain.base.tactics.entity;

import com.bmf.domain.base.enums.BusinessDomainNameEnum;
import lombok.Data;

@Data
public abstract class BusinessEntity {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;
    /**
     * 业务实体唯一ID
     */
    private String businessEntityId;

    public BusinessEntity() {
        this.businessEntityId = buildBusinessEntityId();
    }

    /**
     * 构建业务实体唯一ID
     */
    public abstract String buildBusinessEntityId();
}
