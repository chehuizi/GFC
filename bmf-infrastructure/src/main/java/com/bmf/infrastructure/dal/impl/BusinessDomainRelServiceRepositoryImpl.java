package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.DomainRelService;
import com.bmf.infrastructure.dal.BusinessDomainRelServiceRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelServiceMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelServicePO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainRelServiceRepositoryImpl implements BusinessDomainRelServiceRepository {

    @Resource
    private BusinessDomainRelServiceMapper businessDomainRelServiceMapper;

    @Override
    public BusinessDomainRelServicePO selectOne(DomainRelService req) {
        BusinessDomainRelServicePO domainRelServicePO = new BusinessDomainRelServicePO();
        return businessDomainRelServiceMapper.selectOne(domainRelServicePO);
    }

    @Override
    public boolean insert(DomainRelService req) {
        BusinessDomainRelServicePO domainRelServicePO = new BusinessDomainRelServicePO();
        return businessDomainRelServiceMapper.insert(domainRelServicePO) == 1;
    }

    @Override
    public boolean update(DomainRelService req) {
        return false;
    }

    @Override
    public boolean delete(DomainRelService req) {
        return false;
    }
}
