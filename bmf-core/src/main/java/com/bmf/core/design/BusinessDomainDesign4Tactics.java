package com.bmf.core.design;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.aggregate.DomainAggregate;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.valueobject.DomainValueObject;

/**
 * 业务设计
 */
public interface BusinessDomainDesign4Tactics {

    /**
     * 添加领域实体
     * @param domain
     * @param entity
     * @return
     */
    boolean addEntity(BusinessDomain domain, DomainEntity entity);

    /**
     * 删除领域实体
     * @param entity
     * @return
     */
    boolean delEntity(DomainEntity entity);

    /**
     * 添加领域服务
     * @param domain
     * @param service
     * @return
     */
    boolean addService(BusinessDomain domain, DomainService service);

    /**
     * 删除领域服务
     * @param service
     * @return
     */
    boolean delService(DomainService service);

    /**
     * 添加值对象
     * @param domain
     * @param valueObject
     * @return
     */
    boolean addValueObject(BusinessDomain domain, DomainValueObject valueObject);

    /**
     * 删除值对象
     * @param valueObject
     * @return
     */
    boolean delValueObject(DomainValueObject valueObject);

    /**
     * 添加领域事件
     * @param domain
     * @param domainEvent
     * @return
     */
    boolean addDomainEvent(BusinessDomain domain, DomainEvent domainEvent);

    /**
     * 构建实体和值对象关系
     * @param entity
     * @param valueObject
     * @return
     */
    boolean addEntityRelVO(DomainEntity entity, DomainValueObject valueObject);

    /**
     * 添加聚合根
     * @param domain
     * @param aggregate
     * @return
     */
    boolean addAggregate(BusinessDomain domain, DomainAggregate aggregate);

}
