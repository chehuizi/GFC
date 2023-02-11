package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.infrastructure.dal.BusinessDomainEntityRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEntityMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainEntityRepositoryImpl implements BusinessDomainEntityRepository {

    @Resource
    private BusinessDomainEntityMapper businessDomainEntityMapper;

    @Override
    public BusinessDomainEntityPO selectOne(BusinessDomainEntity req) {
        BusinessDomainEntityPO domainEntityPO = DomainPOUtil.convert(req);
        return businessDomainEntityMapper.selectOne(domainEntityPO);
    }

    @Override
    public boolean insert(BusinessDomainEntity req) {
        BusinessDomainEntityPO domainEntityPO = DomainPOUtil.convert(req);
        return businessDomainEntityMapper.insert(domainEntityPO) == 1;
    }

    @Override
    public boolean update(BusinessDomainEntity req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainEntity req) {
        BusinessDomainEntityPO domainEntityPO = DomainPOUtil.convert(req);
        return businessDomainEntityMapper.delete(domainEntityPO) == 1;
    }
}
