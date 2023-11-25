package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.tactics.event.DomainEventAttr;
import com.bmf.design.infrastructure.dal.mapper.DomainEventAttrMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainEventAttrRepository;
import com.bmf.design.infrastructure.dal.po.DomainEventAttrPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEventAttrRepositoryImpl implements DomainEventAttrRepository {

    @Autowired
    private DomainEventAttrMapper domainEventAttrMapper;

    @Override
    public DomainEventAttr selectOne(DomainEventAttr req) {
        return null;
    }

    @Override
    public List<DomainEventAttr> selectByEventCode(Integer eventCode) {
        return POUtils.convert(domainEventAttrMapper.selectByEventCode(eventCode), DomainEventAttr.class);
    }

    @Override
    public boolean insert(DomainEventAttr req) {
        DomainEventAttrPO domainEventAttrPO = POUtils.convert(req, DomainEventAttrPO.class);
        return domainEventAttrMapper.insert(domainEventAttrPO) == 1;
    }

    @Override
    public boolean update(DomainEventAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainEventAttr req) {
        DomainEventAttrPO domainEventAttrPO = POUtils.convert(req, DomainEventAttrPO.class);
        return domainEventAttrMapper.delete(domainEventAttrPO) == 1;
    }
}
