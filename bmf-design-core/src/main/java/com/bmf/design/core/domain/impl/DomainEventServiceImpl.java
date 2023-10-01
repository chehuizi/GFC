package com.bmf.design.core.domain.impl;

import com.bmf.design.base.tactics.event.DomainEvent;
import com.bmf.design.base.tactics.event.DomainEventAttr;
import com.bmf.design.core.domain.DomainEventService;
import com.bmf.design.infrastructure.dal.DomainEventAttrRepository;
import com.bmf.design.infrastructure.dal.DomainEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEventServiceImpl implements DomainEventService {

    @Autowired
    private DomainEventRepository domainEventRepository;
    @Autowired
    private DomainEventAttrRepository domainEventAttrRepository;

    @Override
    public DomainEvent queryDomainEvent(DomainEvent domainEvent) {
        return domainEventRepository.selectOne(domainEvent);
    }

    @Override
    public List<DomainEvent> queryByDomainCode(Integer domainCode) {
        return domainEventRepository.selectByDomainCode(domainCode);
    }

    @Override
    public List<DomainEventAttr> queryEventAttr(Integer eventCode) {
        return domainEventAttrRepository.selectByEventCode(eventCode);
    }

    @Override
    public Boolean addEventAttr(DomainEventAttr eventAttr) {
        return domainEventAttrRepository.insert(eventAttr);
    }

    @Override
    public Boolean delEventAttr(DomainEventAttr eventAttr) {
        return domainEventAttrRepository.delete(eventAttr);
    }
}
