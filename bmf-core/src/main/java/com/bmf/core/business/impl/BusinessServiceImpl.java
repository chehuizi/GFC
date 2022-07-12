package com.bmf.core.business.impl;

import com.bmf.api.Result;
import com.bmf.base.Business;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.core.business.BusinessService;
import com.bmf.design.BusinessDomainDesign4Strategy;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private BusinessRelDomainRepository businessRelDomainRepository;
    @Autowired
    private BusinessDomainDesign4Strategy businessDomainDesign4Strategy;

    @Override
    public Result<Boolean> addBusiness(Business business) {
        boolean ret = businessRepository.insert(business);
        return Result.success(ret);
    }

    @Override
    public Result<Boolean> addDomain(BusinessRelDomainDO businessRelDomainDO) {
        boolean result = businessRelDomainRepository.insert(businessRelDomainDO);
        return Result.success(result);
    }

    @Override
    public Result<Boolean> addDomainRelation(BusinessDomainRelationship businessDomainRelationship) {
        boolean result = businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessDomainRelationship);
        return Result.success(result);
    }
}
