package com.bmf.infrastructure.dal.impl;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelationMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.utils.BusinessPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessDomainRelationRepositoryImpl implements BusinessDomainRelationRepository {

    @Resource
    private BusinessDomainRelationMapper businessDomainRelationMapper;

    @Override
    public BusinessDomainRelationPO selectOne(BusinessDomainRelation req) {
        return null;
    }

    @Override
    public List<BusinessDomainRelationPO> selectList(BusinessDomainRelation req) {
        BusinessDomainRelationPO businessDomainRelationPO = BusinessPOUtil.convert(req);
        return businessDomainRelationMapper.selectList(businessDomainRelationPO);
    }

    @Override
    public List<BusinessDomainRelationPO> selectByDomain(BusinessDomainRelation req) {
        BusinessDomainRelationPO businessDomainRelationPO = BusinessPOUtil.convert(req);
        return businessDomainRelationMapper.selectByDomain(businessDomainRelationPO);
    }

    @Override
    public boolean insert(BusinessDomainRelation req) {
        return businessDomainRelationMapper.insert(BusinessPOUtil.convert(req)) == 1;
    }

    @Override
    public boolean update(BusinessDomainRelation req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainRelation req) {
        return businessDomainRelationMapper.delete(BusinessPOUtil.convert(req)) == 1;
    }
}
