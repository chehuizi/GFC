package com.bmf.core.design.impl;

import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessDomainDesign4StrategyImpl implements BusinessDomainDesign4Strategy {

    @Autowired
    private BusinessDomainRelationRepository businessDomainRelationRepository;

    @Override
    public boolean buildBusinessDomainRelationship(BusinessDomainRelationship relationship) {
        boolean result = businessDomainRelationRepository.insert(relationship);
        return result;
    }

    @Override
    public boolean removeBusinessDomainRelationship(BusinessDomainRelationship relationship) {
        businessDomainRelationRepository.delete(relationship);
        return false;
    }
}
