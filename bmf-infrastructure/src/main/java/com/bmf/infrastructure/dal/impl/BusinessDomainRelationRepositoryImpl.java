package com.bmf.infrastructure.dal.impl;

import com.bmf.api.business.BusinessReqDTO;
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
    public BusinessDomainRelationPO selectOne(BusinessReqDTO req) {
        return null;
    }

    @Override
    public boolean insert(BusinessReqDTO req) {
        BusinessDomainRelationPO businessDomainRelationPO = new BusinessDomainRelationPO();
        businessDomainRelationPO.setBusinessCode(req.getBusiness().getBusinessCode());
        businessDomainRelationPO.setDomainRelation(req.getRelationship().getRelationship());
        businessDomainRelationPO.setDomainACode(req.getRelationship().getRoleA().getDomain().getDomainCode());
        businessDomainRelationPO.setDomainARole(req.getRelationship().getRoleA().getRole());
        businessDomainRelationPO.setDomainBCode(req.getRelationship().getRoleB().getDomain().getDomainCode());
        businessDomainRelationPO.setDomainBRole(req.getRelationship().getRoleB().getRole());
        return businessDomainRelationMapper.insert(businessDomainRelationPO) == 1;
    }

    @Override
    public boolean update(BusinessReqDTO req) {
        return false;
    }

    @Override
    public boolean delete(BusinessReqDTO req) {
        return false;
    }
}
