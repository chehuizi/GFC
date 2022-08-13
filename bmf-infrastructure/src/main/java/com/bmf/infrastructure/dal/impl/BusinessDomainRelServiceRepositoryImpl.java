package com.bmf.infrastructure.dal.impl;

import com.bmf.base.DO.DomainRelServiceDO;
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
    public BusinessDomainRelServicePO selectOne(DomainRelServiceDO req) {
        BusinessDomainRelServicePO domainRelServicePO = new BusinessDomainRelServicePO();
        return businessDomainRelServiceMapper.selectOne(domainRelServicePO);
    }

    @Override
    public boolean insert(DomainRelServiceDO req) {
        BusinessDomainRelServicePO domainRelServicePO = new BusinessDomainRelServicePO();
        return businessDomainRelServiceMapper.insert(domainRelServicePO) == 1;
    }

    @Override
    public boolean update(DomainRelServiceDO req) {
        return false;
    }

    @Override
    public boolean delete(DomainRelServiceDO req) {
        return false;
    }
}
