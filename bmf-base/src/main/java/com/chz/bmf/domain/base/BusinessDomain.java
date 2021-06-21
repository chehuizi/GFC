package com.chz.bmf.domain.base;

import com.chz.bmf.domain.base.entity.BusinessEntity4Domain;
import com.chz.bmf.domain.base.meta.BusinessDomainMeta;
import com.chz.bmf.domain.base.service.BusinessService4Domain;
import lombok.Data;

import java.util.List;

/**
 * 业务领域
 */
@Data
public abstract class BusinessDomain {

    /**
     * 领域元数据
     */
    private BusinessDomainMeta domainMeta;
    /**
     * 领域实体列表
     */
    private List<BusinessEntity4Domain> entityList;
    /**
     * 领域服务列表
     */
    private List<BusinessService4Domain> serviceList;

    public BusinessDomain() {
        this.domainMeta = buildDomainMeta();
        this.entityList = buildEntityList();
        this.serviceList = buildServiceList();
    }

    public abstract BusinessDomainMeta buildDomainMeta();
    public abstract List<BusinessEntity4Domain> buildEntityList();
    public abstract List<BusinessService4Domain> buildServiceList();
}
