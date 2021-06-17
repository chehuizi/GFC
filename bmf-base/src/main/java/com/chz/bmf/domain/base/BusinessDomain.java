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
public class BusinessDomain {

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

    public BusinessDomain(BusinessDomainMeta domainMeta, List<BusinessEntity4Domain> entityList, List<BusinessService4Domain> serviceList) {
        this.domainMeta = domainMeta;
        this.entityList = entityList;
        this.serviceList = serviceList;
    }
}
