package com.chz.bmf.domain.base.tactics;

import com.chz.bmf.domain.base.BusinessDomain;
import com.chz.bmf.domain.base.meta.BusinessDomainMeta;
import com.chz.bmf.domain.base.tactics.aggregate.BusinessAggregate;
import com.chz.bmf.domain.base.tactics.entity.BusinessEntity;
import com.chz.bmf.domain.base.tactics.service.BusinessService;
import com.chz.bmf.domain.base.tactics.valueObject.BusinessValueObject;

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
    List<BusinessEntity> entityList;
    /**
     * 领域服务列表
     */
    List<BusinessService> serviceList;
    /**
     * 值对象列表
     */
    List<BusinessValueObject> valueObjectList;
    /**
     * 聚合根列表
     */
    List<BusinessAggregate> aggregateList;

}
