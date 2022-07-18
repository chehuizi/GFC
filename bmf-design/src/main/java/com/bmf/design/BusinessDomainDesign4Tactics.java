package com.bmf.design;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.aggregate.BusinessDomainAggregate;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.service.BusinessDomainService;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;

/**
 * 业务设计
 */
public interface BusinessDomainDesign4Tactics {

    /**
     * 添加实体
     * @param domain
     * @param entity
     * @return
     */
    boolean addEntity(BusinessDomain domain, BusinessDomainEntity entity);

    /**
     * 添加值对象
     * @param entity
     * @param valueObject
     * @return
     */
    boolean addValueObject(BusinessDomainEntity entity, BusinessDomainValueObject valueObject);

    /**
     * 添加聚合根
     * @param domain
     * @param aggregate
     * @return
     */
    boolean addAggregate(BusinessDomain domain, BusinessDomainAggregate aggregate);

    /**
     * 添加领域服务
     * @param domain
     * @param service
     * @return
     */
    boolean addService(BusinessDomain domain, BusinessDomainService service);
}
