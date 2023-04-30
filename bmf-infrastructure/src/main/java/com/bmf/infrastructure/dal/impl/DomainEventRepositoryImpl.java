package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.infrastructure.dal.DomainEventRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEventMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEventPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEventRepositoryImpl implements DomainEventRepository {

    @Autowired
    private BusinessDomainEventMapper domainEventMapper;

    @Override
    public DomainEvent selectOne(DomainEvent req) {
        BusinessDomainEventPO domainEventPO = POUtils.convert(req, BusinessDomainEventPO.class);
        return POUtils.convert(domainEventMapper.selectOne(domainEventPO), DomainEvent.class);
    }

    @Override
    public List<DomainEvent> selectByDomainCode(Integer domainCode) {
        return POUtils.convert(domainEventMapper.selectByDomainCode(domainCode), DomainEvent.class);
    }

    @Override
    public boolean insert(DomainEvent req) {
        BusinessDomainEventPO domainEventPO = POUtils.convert(req, BusinessDomainEventPO.class);
        return domainEventMapper.insert(domainEventPO) == 1;
    }

    @Override
    public boolean update(DomainEvent req) {
        return false;
    }

    @Override
    public boolean delete(DomainEvent req) {
        BusinessDomainEventPO domainEventPO = POUtils.convert(req, BusinessDomainEventPO.class);
        return domainEventMapper.delete(domainEventPO) == 1;
    }
}
