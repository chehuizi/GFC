package com.bmf.core.domain.impl;

import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.infrastructure.dal.DomainEntityAttrRepository;
import com.bmf.infrastructure.dal.DomainEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainEntityServiceImpl implements DomainEntityService {

    @Autowired
    private DomainEntityRepository domainEntityRepository;
    @Autowired
    private DomainEntityAttrRepository domainEntityAttrRepository;

    @Override
    public DomainEntity queryDomainEntity(DomainEntity domainEntity) {
        return domainEntityRepository.selectOne(domainEntity);
    }

    @Override
    public Boolean addEntityAttr(DomainEntityAttr entityAttr) {
        return domainEntityAttrRepository.insert(entityAttr);
    }

    @Override
    public Boolean delEntityAttr(DomainEntityAttr entityAttr) {
        return domainEntityAttrRepository.delete(entityAttr);
    }
}
