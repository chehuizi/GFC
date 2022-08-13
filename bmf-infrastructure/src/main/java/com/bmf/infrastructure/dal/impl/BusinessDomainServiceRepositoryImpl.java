package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.service.BusinessDomainService;
import com.bmf.infrastructure.dal.BusinessDomainServiceRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainServiceMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainServicePO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainServiceRepositoryImpl implements BusinessDomainServiceRepository {

    @Resource
    private BusinessDomainServiceMapper businessDomainServiceMapper;

    @Override
    public BusinessDomainServicePO selectOne(BusinessDomainService req) {
        BusinessDomainServicePO domainServicePO = new BusinessDomainServicePO();
        return businessDomainServiceMapper.selectOne(domainServicePO);
    }

    @Override
    public boolean insert(BusinessDomainService req) {
        BusinessDomainServicePO domainServicePO = new BusinessDomainServicePO();
        return businessDomainServiceMapper.insert(domainServicePO) == 1;
    }

    @Override
    public boolean update(BusinessDomainService req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainService req) {
        return false;
    }
}
