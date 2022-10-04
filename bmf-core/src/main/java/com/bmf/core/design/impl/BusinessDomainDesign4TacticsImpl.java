package com.bmf.core.design.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.DomainRelEntityDO;
import com.bmf.base.DO.DomainRelServiceDO;
import com.bmf.base.DO.EntityRelVODO;
import com.bmf.base.tactics.aggregate.BusinessDomainAggregate;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.event.BusinessDomainEvent;
import com.bmf.base.tactics.service.BusinessDomainService;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;
import com.bmf.common.utils.DomainUtil;
import com.bmf.core.design.BusinessDomainDesign4Tactics;
import com.bmf.infrastructure.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessDomainDesign4TacticsImpl implements BusinessDomainDesign4Tactics {

    @Autowired
    private BusinessDomainEntityRepository businessDomainEntityRepository;
    @Autowired
    private BusinessDomainRelEntityRepository businessDomainRelEntityRepository;
    @Autowired
    private BusinessDomainServiceRepository businessDomainServiceRepository;
    @Autowired
    private BusinessDomainRelServiceRepository businessDomainRelServiceRepository;
    @Autowired
    private BusinessDomainValueObjectRepository businessDomainValueObjectRepository;
    @Autowired
    private BusinessDomainEntityRelVORepository businessDomainEntityRelVORepository;

    @Override
    @Transactional
    public boolean addEntity(BusinessDomain domain, BusinessDomainEntity entity) {
        boolean insertOk = businessDomainEntityRepository.insert(entity);
        if (insertOk) {
            DomainRelEntityDO domainRelEntityDO = DomainUtil.build(domain, entity);
            return businessDomainRelEntityRepository.insert(domainRelEntityDO);
        }
        return false;
    }

    @Override
    public boolean addValueObject(BusinessDomain domain, BusinessDomainValueObject valueObject) {
        return businessDomainValueObjectRepository.insert(valueObject);
    }

    @Override
    public boolean addEntityRelVO(BusinessDomainEntity entity, BusinessDomainValueObject valueObject) {
        EntityRelVODO entityRelVODO = DomainUtil.build(entity, valueObject);
        return businessDomainEntityRelVORepository.insert(entityRelVODO);
    }

    @Override
    public boolean addAggregate(BusinessDomain domain, BusinessDomainAggregate aggregate) {
        return false;
    }

    @Override
    public boolean addService(BusinessDomain domain, BusinessDomainService service) {
        boolean insertOk = businessDomainServiceRepository.insert(service);
        if (insertOk) {
            DomainRelServiceDO domainRelServiceDO = DomainUtil.build(domain, service);
            return businessDomainRelServiceRepository.insert(domainRelServiceDO);
        }
        return false;
    }

    @Override
    public boolean addDomainEvent(BusinessDomain domain, BusinessDomainEvent domainEvent) {
        return false;
    }
}
