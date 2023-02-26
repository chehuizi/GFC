package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.event.DomainEventAttr;
import com.bmf.infrastructure.dal.DomainEventAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEventAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEventAttrPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainEventAttrRepositoryImpl implements DomainEventAttrRepository {

    @Resource
    private BusinessDomainEventAttrMapper businessDomainEventAttrMapper;

    @Override
    public BusinessDomainEventAttrPO selectOne(DomainEventAttr req) {
        return null;
    }

    @Override
    public boolean insert(DomainEventAttr req) {
        BusinessDomainEventAttrPO domainEventAttrPO = POUtils.convert(req, BusinessDomainEventAttrPO.class);
        return businessDomainEventAttrMapper.insert(domainEventAttrPO) == 1;
    }

    @Override
    public boolean update(DomainEventAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainEventAttr req) {
        BusinessDomainEventAttrPO domainEventAttrPO = POUtils.convert(req, BusinessDomainEventAttrPO.class);
        return businessDomainEventAttrMapper.delete(domainEventAttrPO) == 1;
    }
}
