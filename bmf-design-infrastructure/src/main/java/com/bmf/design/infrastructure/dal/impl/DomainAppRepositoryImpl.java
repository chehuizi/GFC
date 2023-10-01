package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.application.DomainApp;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainAppRepository;
import com.bmf.design.infrastructure.dal.mapper.DomainAppMapper;
import com.bmf.design.infrastructure.dal.po.DomainAppPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainAppRepositoryImpl implements DomainAppRepository {

    @Autowired
    private DomainAppMapper domainAppMapper;

    @Override
    public DomainApp selectOne(DomainApp req) {
        DomainAppPO domainAppPO = POUtils.convert(req, DomainAppPO.class);
        return POUtils.convert(domainAppMapper.selectOne(domainAppPO), DomainApp.class);
    }

    @Override
    public DomainApp selectByDomainCode(Integer domainCode) {
        return POUtils.convert(domainAppMapper.selectByDomainCode(domainCode), DomainApp.class);
    }

    @Override
    public boolean insert(DomainApp req) {
        DomainAppPO domainAppPO = POUtils.convert(req, DomainAppPO.class);
        return domainAppMapper.insert(domainAppPO) == 1;
    }

    @Override
    public boolean update(DomainApp req) {
        return false;
    }

    @Override
    public boolean delete(DomainApp req) {
        return false;
    }
}
