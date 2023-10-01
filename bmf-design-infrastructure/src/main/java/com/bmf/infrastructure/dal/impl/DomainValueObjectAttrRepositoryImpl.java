package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.infrastructure.dal.DomainValueObjectAttrRepository;
import com.bmf.infrastructure.dal.mapper.DomainValueObjectAttrMapper;
import com.bmf.infrastructure.dal.po.DomainValueObjectAttrPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainValueObjectAttrRepositoryImpl implements DomainValueObjectAttrRepository {

    @Autowired
    private DomainValueObjectAttrMapper domainValueObjectAttrMapper;

    @Override
    public DomainValueObjectAttr selectOne(DomainValueObjectAttr req) {
        return null;
    }

    @Override
    public boolean insert(DomainValueObjectAttr req) {
        DomainValueObjectAttrPO valueObjectAttrPO = POUtils.convert(req, DomainValueObjectAttrPO.class);
        return domainValueObjectAttrMapper.insert(valueObjectAttrPO) == 1;
    }

    @Override
    public boolean update(DomainValueObjectAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainValueObjectAttr req) {
        DomainValueObjectAttrPO valueObjectAttrPO = POUtils.convert(req, DomainValueObjectAttrPO.class);
        return domainValueObjectAttrMapper.delete(valueObjectAttrPO) == 1;
    }
}
