package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.infrastructure.dal.DomainValueObjectAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainValueObjectAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectAttrPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainValueObjectAttrRepositoryImpl implements DomainValueObjectAttrRepository {

    @Autowired
    private BusinessDomainValueObjectAttrMapper businessDomainValueObjectAttrMapper;

    @Override
    public DomainValueObjectAttr selectOne(DomainValueObjectAttr req) {
        return null;
    }

    @Override
    public boolean insert(DomainValueObjectAttr req) {
        BusinessDomainValueObjectAttrPO valueObjectAttrPO = POUtils.convert(req, BusinessDomainValueObjectAttrPO.class);
        return businessDomainValueObjectAttrMapper.insert(valueObjectAttrPO) == 1;
    }

    @Override
    public boolean update(DomainValueObjectAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainValueObjectAttr req) {
        BusinessDomainValueObjectAttrPO valueObjectAttrPO = POUtils.convert(req, BusinessDomainValueObjectAttrPO.class);
        return businessDomainValueObjectAttrMapper.delete(valueObjectAttrPO) == 1;
    }
}
