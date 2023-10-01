package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.service.DomainService;
import com.bmf.infrastructure.dal.DomainServiceRepository;
import com.bmf.infrastructure.dal.mapper.DomainServiceMapper;
import com.bmf.infrastructure.dal.po.DomainServicePO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceRepositoryImpl implements DomainServiceRepository {

    @Autowired
    private DomainServiceMapper domainServiceMapper;

    @Override
    public DomainService selectOne(DomainService req) {
        DomainServicePO domainServicePO = POUtils.convert(req, DomainServicePO.class);
        return POUtils.convert(domainServiceMapper.selectOne(domainServicePO), DomainService.class);
    }

    @Override
    public List<DomainService> selectByDomainCode(Integer domainCode) {
        return POUtils.convert(domainServiceMapper.selectByDomainCode(domainCode), DomainService.class);
    }

    @Override
    public boolean insert(DomainService req) {
        DomainServicePO domainServicePO = POUtils.convert(req, DomainServicePO.class);
        return domainServiceMapper.insert(domainServicePO) == 1;
    }

    @Override
    public boolean update(DomainService req) {
        return false;
    }

    @Override
    public boolean delete(DomainService req) {
        DomainServicePO domainServicePO = POUtils.convert(req, DomainServicePO.class);
        return domainServiceMapper.delete(domainServicePO) == 1;
    }
}
