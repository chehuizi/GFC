package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.event.DomainEventAttr;
import com.bmf.infrastructure.dal.DomainEventAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEventAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEventAttrPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEventAttrRepositoryImpl implements DomainEventAttrRepository {

    @Autowired
    private BusinessDomainEventAttrMapper businessDomainEventAttrMapper;

    @Override
    public DomainEventAttr selectOne(DomainEventAttr req) {
        return null;
    }

    @Override
    public List<DomainEventAttr> selectByEventCode(Integer eventCode) {
        return POUtils.convert(businessDomainEventAttrMapper.selectByEventCode(eventCode), DomainEventAttr.class);
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
