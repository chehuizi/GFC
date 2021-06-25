package com.chz.bmf.domain.base.tactics;

import com.chz.bmf.domain.base.BusinessDomain;
import com.chz.bmf.domain.base.tactics.entity.BusinessEntity4Domain;
import com.chz.bmf.domain.base.meta.BusinessDomainMeta;
import com.chz.bmf.domain.base.tactics.service.BusinessService4Domain;

import java.util.List;

/**
 * 业务领域
 */
public class BusinessDomainInTactics extends BusinessDomain {

    /**
     * 领域元数据
     */
    BusinessDomainMeta domainMeta;
    /**
     * 领域实体列表
     */
    List<BusinessEntity4Domain> entityList;
    /**
     * 领域服务列表
     */
    List<BusinessService4Domain> serviceList;

}
