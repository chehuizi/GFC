package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.event.DomainEventAttr;
import com.bmf.infrastructure.dal.DomainEventAttrRepository;
import com.bmf.infrastructure.dal.mapper.DomainEventAttrMapper;
import com.bmf.infrastructure.dal.po.DomainEventAttrPO;
import com.bmf.infrastructure.dal.utils.POUtils;
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
