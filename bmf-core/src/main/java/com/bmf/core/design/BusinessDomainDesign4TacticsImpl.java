package com.bmf.core.design;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.aggregate.BusinessDomainAggregate;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.service.BusinessDomainService;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;
import com.bmf.design.BusinessDomainDesign4Tactics;
import org.springframework.stereotype.Service;

@Service
public class BusinessDomainDesign4TacticsImpl implements BusinessDomainDesign4Tactics {

    @Override
    public boolean addEntity(BusinessDomain domain, BusinessDomainEntity entity) {
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
