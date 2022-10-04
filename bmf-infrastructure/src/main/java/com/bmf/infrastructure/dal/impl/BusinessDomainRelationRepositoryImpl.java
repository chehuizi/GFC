package com.bmf.infrastructure.dal.impl;

import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelationMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.utils.BusinessPOUtil;
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
        return businessDomainRelationMapper.insert(BusinessPOUtil.convert(req)) == 1;
    }

    @Override
    public boolean update(BusinessDomainRelationship req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainRelationship req) {
        return businessDomainRelationMapper.delete(BusinessPOUtil.convert(req)) == 1;
    }
}
