package com.bmf.design.core.tactics.impl;

import com.bmf.design.model.Domain;
import com.bmf.design.model.tactics.entity.DomainEntityRelVO;
import com.bmf.design.model.tactics.aggregate.DomainAggregate;
import com.bmf.design.model.tactics.entity.DomainEntity;
import com.bmf.design.model.tactics.event.DomainEvent;
import com.bmf.design.model.tactics.service.DomainService;
import com.bmf.design.model.tactics.valueobject.DomainValueObject;
import com.bmf.design.core.utils.DomainUtil;
import com.bmf.design.core.tactics.BusinessDomainDesign4Tactics;
import com.bmf.design.infrastructure.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean addEntity(Domain domain, DomainEntity entity) {
        return domainEntityRepository.insert(entity);
    }

    @Override
    public boolean delEntity(DomainEntity entity) {
        return domainEntityRepository.delete(entity);
    }

    @Override
    public boolean addService(Domain domain, DomainService service) {
        return domainServiceRepository.insert(service);
    }

    @Override
    public boolean delService(DomainService service) {
        return domainServiceRepository.delete(service);
    }

    @Override
    public boolean addValueObject(Domain domain, DomainValueObject valueObject) {
        return domainValueObjectRepository.insert(valueObject);
    }

    @Override
    public boolean delValueObject(DomainValueObject valueObject) {
        return domainValueObjectRepository.delete(valueObject);
    }

    @Override
    public boolean addDomainEvent(Domain domain, DomainEvent domainEvent) {
        return domainEventRepository.insert(domainEvent);
    }

    @Override
    public boolean delDomainEvent(DomainEvent domainEvent) {
        return domainEventRepository.delete(domainEvent);
    }

    @Override
    public boolean addEntityRelVO(DomainEntity entity, DomainValueObject valueObject) {
        DomainEntityRelVO domainEntityRelVO = DomainUtil.build(entity, valueObject);
        return domainEntityRelVORepository.insert(domainEntityRelVO);
    }

    @Override
    public boolean delEntityRelVO(DomainEntity entity, DomainValueObject valueObject) {
        DomainEntityRelVO domainEntityRelVO = DomainUtil.build(entity, valueObject);
        return domainEntityRelVORepository.delete(domainEntityRelVO);
    }

    @Override
    public boolean addAggregate(Domain domain, DomainAggregate aggregate) {
        return false;
    }

}
