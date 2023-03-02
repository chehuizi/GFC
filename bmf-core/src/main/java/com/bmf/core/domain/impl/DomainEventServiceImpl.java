package com.bmf.core.domain.impl;

import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.event.DomainEventAttr;
import com.bmf.core.domain.DomainEventService;
import com.bmf.infrastructure.dal.DomainEventAttrRepository;
import com.bmf.infrastructure.dal.DomainEventRepository;
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
    public List<DomainEvent> queryByDomainCode(Integer domainCode) {
        return null;
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
