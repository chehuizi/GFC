package com.bmf.core.design;

import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.DomainRelEntityDO;
import com.bmf.base.tactics.aggregate.BusinessDomainAggregate;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.service.BusinessDomainService;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;
import com.bmf.common.utils.DomainUtil;
import com.bmf.design.BusinessDomainDesign4Tactics;
import com.bmf.infrastructure.dal.BusinessDomainEntityRepository;
import com.bmf.infrastructure.dal.BusinessDomainRelEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessDomainDesign4TacticsImpl implements BusinessDomainDesign4Tactics {

    @Autowired
    private BusinessDomainEntityRepository businessDomainEntityRepository;
    @Autowired
    private BusinessDomainRelEntityRepository businessDomainRelEntityRepository;


    @Override
    public boolean addEntity(BusinessDomain domain, BusinessDomainEntity entity) {
        boolean insertOk = businessDomainEntityRepository.insert(entity);
        if (insertOk) {
            DomainRelEntityDO domainRelEntityDO = DomainUtil.build(domain, entity);
            return businessDomainRelEntityRepository.insert(domainRelEntityDO);
        }
        return false;
    }

    @Override
    public boolean addValueObject(BusinessDomainEntity entity, BusinessDomainValueObject valueObject) {
        return false;
    }

    @Override
    public boolean addAggregate(BusinessDomain domain, BusinessDomainAggregate aggregate) {
        return false;
    }

    @Override
    public boolean addService(BusinessDomain domain, BusinessDomainService service) {
        return false;
    }
}
