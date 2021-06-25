package com.chz.bmf.domain.base.tactics.entity;

import com.chz.bmf.domain.base.meta.BusinessDomainNameEnum;
import lombok.Data;

@Data
public abstract class BusinessEntity4Domain {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;
    /**
     * 业务实体唯一ID
     */
    private String businessEntityId;

    public BusinessEntity4Domain() {
        this.businessEntityId = buildBusinessEntityId();
    }

    /**
     * 构建业务实体唯一ID
     */
    public abstract String buildBusinessEntityId();
}
