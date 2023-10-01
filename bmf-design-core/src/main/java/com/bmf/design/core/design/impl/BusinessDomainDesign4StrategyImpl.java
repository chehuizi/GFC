package com.bmf.design.core.design.impl;

import com.bmf.design.base.Business;
import com.bmf.design.base.DomainRelation;
import com.bmf.design.base.strategy.DomainRelationship;
import com.bmf.design.core.utils.BusinessUtil;
import com.bmf.design.core.design.BusinessDomainDesign4Strategy;
import com.bmf.design.infrastructure.dal.DomainRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDomainDesign4StrategyImpl implements BusinessDomainDesign4Strategy {

    @Autowired
    private DomainRelationRepository domainRelationRepository;

    @Override
    public boolean buildBusinessDomainRelationship(DomainRelationship relationship) {
        DomainRelation domainRelation = BusinessUtil.convert(null, relationship);
        return domainRelationRepository.insert(domainRelation);
    }

    @Override
    public boolean batchBuildBusinessDomainRelationship(Business business, List<DomainRelationship> relationshipList) {
        List<DomainRelation> domainRelationList = BusinessUtil.convert(business, relationshipList);
        return domainRelationRepository.batchInsert(domainRelationList);
    }

    @Override
    public boolean removeBusinessDomainRelationship(DomainRelationship relationship) {
        DomainRelation domainRelation = BusinessUtil.convert(null, relationship);
        return domainRelationRepository.delete(domainRelation);
    }
}
