package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.tactics.event.DomainEvent;
import com.bmf.design.infrastructure.dal.mapper.DomainEventMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainEventRepository;
import com.bmf.design.infrastructure.dal.po.DomainEventPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEventRepositoryImpl implements DomainEventRepository {

    @Autowired
    private DomainEventMapper domainEventMapper;

    @Override
    public DomainEvent selectOne(DomainEvent req) {
        DomainEventPO domainEventPO = POUtils.convert(req, DomainEventPO.class);
        return POUtils.convert(domainEventMapper.selectOne(domainEventPO), DomainEvent.class);
    }

    @Override
    public List<DomainEvent> selectByDomainCode(Integer domainCode) {
        return POUtils.convert(domainEventMapper.selectByDomainCode(domainCode), DomainEvent.class);
    }

    @Override
    public boolean insert(DomainEvent req) {
        DomainEventPO domainEventPO = POUtils.convert(req, DomainEventPO.class);
        return domainEventMapper.insert(domainEventPO) == 1;
    }

    @Override
    public boolean update(DomainEvent req) {
        return false;
    }

    @Override
    public boolean delete(DomainEvent req) {
        DomainEventPO domainEventPO = POUtils.convert(req, DomainEventPO.class);
        return domainEventMapper.delete(domainEventPO) == 1;
    }
}
