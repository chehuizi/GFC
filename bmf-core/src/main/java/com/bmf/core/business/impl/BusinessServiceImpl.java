package com.bmf.core.business.impl;

import com.bmf.base.Business;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.core.business.BusinessService;
import com.bmf.design.BusinessDomainDesign4Strategy;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.utils.BusinessPOUtil;
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
    public boolean createBusiness(Business business) {
        boolean result = businessRepository.insert(business);
        return result;
    }

    @Override
    public Business queryBusiness(Business business) {
        BusinessPO businessPO = businessRepository.selectOne(business);
        return BusinessPOUtil.convert(businessPO);
    }

    @Override
    public boolean addDomain(BusinessRelDomainDO businessRelDomainDO) {
        boolean result = businessRelDomainRepository.insert(businessRelDomainDO);
        return result;
    }

    @Override
    public boolean addDomainRelation(BusinessDomainRelationship businessDomainRelationship) {
        boolean result = businessDomainDesign4Strategy.buildBusinessDomainRelationship(businessDomainRelationship);
        return result;
    }
}
