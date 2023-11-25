package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.design.infrastructure.dal.mapper.DomainValueObjectAttrMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainValueObjectAttrRepository;
import com.bmf.design.infrastructure.dal.po.DomainValueObjectAttrPO;
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
