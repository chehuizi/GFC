package com.bmf.infrastructure.dal.impl;

import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelationMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainRelationRepositoryImpl implements BusinessDomainRelationRepository {

    @Resource
    private BusinessDomainRelationMapper businessDomainRelationMapper;

    @Override
    public BusinessDomainRelationPO selectOne(BusinessDomainRelationship req) {
        return null;
    }

    @Override
    public boolean insert(BusinessDomainRelationship req) {
        BusinessDomainRelationPO businessDomainRelationPO = new BusinessDomainRelationPO();
        businessDomainRelationPO.setBusinessCode(req.getBusinessCode());
        businessDomainRelationPO.setDomainRelation(req.getRelationship());
        businessDomainRelationPO.setDomainACode(req.getRoleA().getDomain().getDomainCode());
        businessDomainRelationPO.setDomainARole(req.getRoleA().getRole());
        businessDomainRelationPO.setDomainBCode(req.getRoleB().getDomain().getDomainCode());
        businessDomainRelationPO.setDomainBRole(req.getRoleB().getRole());
        return businessDomainRelationMapper.insert(businessDomainRelationPO) == 1;
    }

    @Override
    public boolean update(BusinessDomainRelationship req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainRelationship req) {
        return false;
    }
}
