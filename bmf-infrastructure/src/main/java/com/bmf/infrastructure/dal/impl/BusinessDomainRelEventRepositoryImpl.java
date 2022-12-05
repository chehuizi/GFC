package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.DomainRelEvent;
import com.bmf.infrastructure.dal.BusinessDomainRelEventRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelEventMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelEventPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainRelEventRepositoryImpl implements BusinessDomainRelEventRepository {

    @Resource
    private BusinessDomainRelEventMapper businessDomainRelEventMapper;

    @Override
    public BusinessDomainRelEventPO selectOne(DomainRelEvent req) {
        BusinessDomainRelEventPO domainRelEventPO = new BusinessDomainRelEventPO();
        return businessDomainRelEventMapper.selectOne(domainRelEventPO);
    }

    @Override
    public boolean insert(DomainRelEvent req) {
        BusinessDomainRelEventPO domainRelEventPO = new BusinessDomainRelEventPO();
        return businessDomainRelEventMapper.insert(domainRelEventPO) == 1;
    }

    @Override
    public boolean update(DomainRelEvent req) {
        return false;
    }

    @Override
    public boolean delete(DomainRelEvent req) {
        return false;
    }
}
