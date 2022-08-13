package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.event.BusinessDomainEvent;
import com.bmf.infrastructure.dal.BusinessDomainEventRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEventMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEventPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainEventRepositoryImpl implements BusinessDomainEventRepository {

    @Resource
    private BusinessDomainEventMapper businessDomainEventMapper;

    @Override
    public BusinessDomainEventPO selectOne(BusinessDomainEvent req) {
        BusinessDomainEventPO domainEventPO = new BusinessDomainEventPO();
        return businessDomainEventMapper.selectOne(domainEventPO);
    }

    @Override
    public boolean insert(BusinessDomainEvent req) {
        BusinessDomainEventPO domainEventPO = new BusinessDomainEventPO();
        return businessDomainEventMapper.insert(domainEventPO) == 1;
    }

    @Override
    public boolean update(BusinessDomainEvent req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainEvent req) {
        return false;
    }
}
