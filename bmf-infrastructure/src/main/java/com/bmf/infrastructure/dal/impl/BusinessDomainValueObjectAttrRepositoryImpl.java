package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.ValueObjectAttr;
import com.bmf.infrastructure.dal.BusinessDomainValueObjectAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainValueObjectAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectAttrPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainValueObjectAttrRepositoryImpl implements BusinessDomainValueObjectAttrRepository {

    @Resource
    private BusinessDomainValueObjectAttrMapper businessDomainValueObjectAttrMapper;

    @Override
    public BusinessDomainValueObjectAttrPO selectOne(ValueObjectAttr req) {
        return null;
    }

    @Override
    public boolean insert(ValueObjectAttr req) {
        return false;
    }

    @Override
    public boolean update(ValueObjectAttr req) {
        return false;
    }

    @Override
    public boolean delete(ValueObjectAttr req) {
        return false;
    }
}
