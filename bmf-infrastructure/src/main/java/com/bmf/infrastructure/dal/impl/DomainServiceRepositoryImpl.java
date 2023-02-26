package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.service.DomainService;
import com.bmf.infrastructure.dal.DomainServiceRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainServiceMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainServicePO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainServiceRepositoryImpl implements DomainServiceRepository {

    @Resource
    private BusinessDomainServiceMapper businessDomainServiceMapper;

    @Override
    public DomainService selectOne(DomainService req) {
        BusinessDomainServicePO domainServicePO = POUtils.convert(req, BusinessDomainServicePO.class);
        return POUtils.convert(businessDomainServiceMapper.selectOne(domainServicePO), DomainService.class);
    }

    @Override
    public boolean insert(DomainService req) {
        BusinessDomainServicePO domainServicePO = POUtils.convert(req, BusinessDomainServicePO.class);
        return businessDomainServiceMapper.insert(domainServicePO) == 1;
    }

    @Override
    public boolean update(DomainService req) {
        return false;
    }

    @Override
    public boolean delete(DomainService req) {
        BusinessDomainServicePO domainServicePO = POUtils.convert(req, BusinessDomainServicePO.class);
        return businessDomainServiceMapper.delete(domainServicePO) == 1;
    }
}
