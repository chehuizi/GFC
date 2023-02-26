package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.infrastructure.dal.DomainEventRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEventMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEventPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainEventRepositoryImpl implements DomainEventRepository {

    @Resource
    private BusinessDomainEventMapper domainEventMapper;

    @Override
    public BusinessDomainEventPO selectOne(DomainEvent req) {
        BusinessDomainEventPO domainEventPO = DomainPOUtil.convert(req, BusinessDomainEventPO.class);
        return domainEventMapper.selectOne(domainEventPO);
    }

    @Override
    public boolean insert(DomainEvent req) {
        BusinessDomainEventPO domainEventPO = DomainPOUtil.convert(req, BusinessDomainEventPO.class);
        return domainEventMapper.insert(domainEventPO) == 1;
    }

    @Override
    public boolean update(DomainEvent req) {
        return false;
    }

    @Override
    public boolean delete(DomainEvent req) {
        BusinessDomainEventPO domainEventPO = DomainPOUtil.convert(req, BusinessDomainEventPO.class);
        return domainEventMapper.delete(domainEventPO) == 1;
    }
}
