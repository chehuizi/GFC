package com.bmf.infrastructure.dal.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.mapper.DomainMapper;
import com.bmf.infrastructure.dal.po.DomainPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainRepositoryImpl implements DomainRepository {

    @Autowired
    private DomainMapper domainMapper;

    @Override
    public BusinessDomain selectOne(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return POUtils.convert(domainMapper.selectOne(domainPO), BusinessDomain.class);
    }

    @Override
    public List<BusinessDomain> selectList(List<Integer> domainCodeList) {
        return POUtils.convert(domainMapper.selectList(domainCodeList), BusinessDomain.class);
    }

    @Override
    public boolean insert(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.insert(domainPO) == 1;
    }

    @Override
    public boolean update(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.update(domainPO) == 1;
    }

    @Override
    public boolean delete(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.delete(domainPO) == 1;
    }
}
