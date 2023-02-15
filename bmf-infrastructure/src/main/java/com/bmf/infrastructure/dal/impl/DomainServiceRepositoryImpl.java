package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.service.DomainService;
import com.bmf.infrastructure.dal.DomainServiceRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainServiceMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainServicePO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainServiceRepositoryImpl implements DomainServiceRepository {

    @Resource
    private BusinessDomainServiceMapper businessDomainServiceMapper;

    @Override
    public BusinessDomainServicePO selectOne(DomainService req) {
        BusinessDomainServicePO domainServicePO = new BusinessDomainServicePO();
        return businessDomainServiceMapper.selectOne(domainServicePO);
    }

    @Override
    public boolean insert(DomainService req) {
        BusinessDomainServicePO domainServicePO = DomainPOUtil.convert(req);
        return businessDomainServiceMapper.insert(domainServicePO) == 1;
    }

    @Override
    public boolean update(DomainService req) {
        return false;
    }

    @Override
    public boolean delete(DomainService req) {
        return false;
    }
}
