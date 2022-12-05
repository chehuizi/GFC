package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.DomainRelEntity;
import com.bmf.infrastructure.dal.BusinessDomainRelEntityRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelEntityMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelEntityPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainRelEntityRepositoryImpl implements BusinessDomainRelEntityRepository {

    @Resource
    private BusinessDomainRelEntityMapper businessDomainRelEntityMapper;

    @Override
    public BusinessDomainRelEntityPO selectOne(DomainRelEntity req) {
        return null;
    }

    @Override
    public boolean insert(DomainRelEntity req) {
        BusinessDomainRelEntityPO domainRelEntityPO = DomainPOUtil.convert(req);
        return businessDomainRelEntityMapper.insert(domainRelEntityPO) == 1;
    }

    @Override
    public boolean update(DomainRelEntity req) {
        return false;
    }

    @Override
    public boolean delete(DomainRelEntity req) {
        return false;
    }
}
