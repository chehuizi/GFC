package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.infrastructure.dal.DomainEntityRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEntityMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainEntityRepositoryImpl implements DomainEntityRepository {

    @Resource
    private BusinessDomainEntityMapper domainEntityMapper;

    @Override
    public DomainEntity selectOne(DomainEntity req) {
        BusinessDomainEntityPO domainEntityPO = POUtils.convert(req, BusinessDomainEntityPO.class);
        return POUtils.convert(domainEntityMapper.selectOne(domainEntityPO), DomainEntity.class);
    }

    @Override
    public boolean insert(DomainEntity req) {
        BusinessDomainEntityPO domainEntityPO = POUtils.convert(req, BusinessDomainEntityPO.class);
        return domainEntityMapper.insert(domainEntityPO) == 1;
    }

    @Override
    public boolean update(DomainEntity req) {
        return false;
    }

    @Override
    public boolean delete(DomainEntity req) {
        BusinessDomainEntityPO domainEntityPO = POUtils.convert(req, BusinessDomainEntityPO.class);
        return domainEntityMapper.delete(domainEntityPO) == 1;
    }
}
