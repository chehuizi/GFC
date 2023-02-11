package com.bmf.core.design;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.aggregate.BusinessDomainAggregate;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.event.BusinessDomainEvent;
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
     * 删除实体
     * @param entity
     * @return
     */
    boolean delEntity(BusinessDomainEntity entity);

    /**
     * 添加值对象
     * @param domain
     * @param valueObject
     * @return
     */
    boolean addValueObject(BusinessDomain domain, BusinessDomainValueObject valueObject);

    /**
     * 构建实体和值对象关系
     * @param entity
     * @param valueObject
     * @return
     */
    boolean addEntityRelVO(BusinessDomainEntity entity, BusinessDomainValueObject valueObject);

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

    /**
     * 添加领域事件
     * @param domain
     * @param domainEvent
     * @return
     */
    boolean addDomainEvent(BusinessDomain domain, BusinessDomainEvent domainEvent);
}
