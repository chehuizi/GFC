package com.bmf.design.core.design;

import com.bmf.design.base.Domain;
import com.bmf.design.base.tactics.aggregate.DomainAggregate;
import com.bmf.design.base.tactics.entity.DomainEntity;
import com.bmf.design.base.tactics.event.DomainEvent;
import com.bmf.design.base.tactics.service.DomainService;
import com.bmf.design.base.tactics.valueobject.DomainValueObject;

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
    boolean addEntity(Domain domain, DomainEntity entity);

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
    boolean addService(Domain domain, DomainService service);

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
    boolean addValueObject(Domain domain, DomainValueObject valueObject);

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
    boolean addDomainEvent(Domain domain, DomainEvent domainEvent);

    /**
     * 删除领域事件
     * @param domainEvent
     * @return
     */
    boolean delDomainEvent(DomainEvent domainEvent);

    /**
     * 添加实体和值对象关系
     * @param entity
     * @param valueObject
     * @return
     */
    boolean addEntityRelVO(DomainEntity entity, DomainValueObject valueObject);

    /**
     * 删除实体和值对象关系
     * @param entity
     * @param valueObject
     * @return
     */
    boolean delEntityRelVO(DomainEntity entity, DomainValueObject valueObject);

    /**
     * 添加聚合根
     * @param domain
     * @param aggregate
     * @return
     */
    boolean addAggregate(Domain domain, DomainAggregate aggregate);

}
