package com.bmf.core.design.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.EntityRelVO;
import com.bmf.base.tactics.aggregate.DomainAggregate;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.core.utils.DomainUtil;
import com.bmf.core.design.BusinessDomainDesign4Tactics;
import com.bmf.infrastructure.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessDomainDesign4TacticsImpl implements BusinessDomainDesign4Tactics {

    @Autowired
    private DomainEntityRepository domainEntityRepository;
    @Autowired
    private DomainServiceRepository domainServiceRepository;
    @Autowired
    private DomainEventRepository domainEventRepository;
    @Autowired
    private DomainValueObjectRepository domainValueObjectRepository;
    @Autowired
    private DomainEntityRelVORepository domainEntityRelVORepository;

    @Override
    @Transactional
    public boolean addEntity(BusinessDomain domain, DomainEntity entity) {
        return domainEntityRepository.insert(entity);
    }

    @Override
    public boolean delEntity(DomainEntity entity) {
        return domainEntityRepository.delete(entity);
    }

    @Override
    public boolean addService(BusinessDomain domain, DomainService service) {
        return domainServiceRepository.insert(service);
    }

    @Override
    public boolean delService(DomainService service) {
        return domainServiceRepository.delete(service);
    }

    @Override
    public boolean addValueObject(BusinessDomain domain, DomainValueObject valueObject) {
        return domainValueObjectRepository.insert(valueObject);
    }

    @Override
    public boolean delValueObject(DomainValueObject valueObject) {
        return domainValueObjectRepository.delete(valueObject);
    }

    @Override
    public boolean addDomainEvent(BusinessDomain domain, DomainEvent domainEvent) {
        return domainEventRepository.insert(domainEvent);
    }

    @Override
    public boolean delDomainEvent(DomainEvent domainEvent) {
        return domainEventRepository.delete(domainEvent);
    }

    @Override
    public boolean addEntityRelVO(DomainEntity entity, DomainValueObject valueObject) {
        EntityRelVO entityRelVO = DomainUtil.build(entity, valueObject);
        return domainEntityRelVORepository.insert(entityRelVO);
    }

    @Override
    public boolean delEntityRelVO(DomainEntity entity, DomainValueObject valueObject) {
        EntityRelVO entityRelVO = DomainUtil.build(entity, valueObject);
        return domainEntityRelVORepository.delete(entityRelVO);
    }

    @Override
    public boolean addAggregate(BusinessDomain domain, DomainAggregate aggregate) {
        return false;
    }

}
