package com.bmf.core.design.impl;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.core.utils.BusinessUtil;
import com.bmf.core.design.BusinessDomainDesign4Strategy;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDomainDesign4StrategyImpl implements BusinessDomainDesign4Strategy {

    @Autowired
    private BusinessDomainRelationRepository businessDomainRelationRepository;

    @Override
    public boolean buildBusinessDomainRelationship(BusinessDomainRelationship relationship) {
        BusinessDomainRelation businessDomainRelation = BusinessUtil.convert(relationship);
        return businessDomainRelationRepository.insert(businessDomainRelation);
    }

    @Override
    public boolean batchBuildBusinessDomainRelationship(List<BusinessDomainRelationship> relationshipList) {
        List<BusinessDomainRelation> businessDomainRelationList = BusinessUtil.convert(relationshipList);
        return businessDomainRelationRepository.batchInsert(businessDomainRelationList);
    }

    @Override
    public boolean removeBusinessDomainRelationship(BusinessDomainRelationship relationship) {
        BusinessDomainRelation businessDomainRelation = BusinessUtil.convert(relationship);
        return businessDomainRelationRepository.delete(businessDomainRelation);
    }
}
