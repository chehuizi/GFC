package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.infrastructure.dal.DomainValueObjectAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainValueObjectAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectAttrPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainValueObjectAttrRepositoryImpl implements DomainValueObjectAttrRepository {

    @Resource
    private BusinessDomainValueObjectAttrMapper businessDomainValueObjectAttrMapper;

    @Override
    public BusinessDomainValueObjectAttrPO selectOne(DomainValueObjectAttr req) {
        return null;
    }

    @Override
    public boolean insert(DomainValueObjectAttr req) {
        BusinessDomainValueObjectAttrPO valueObjectAttrPO = DomainPOUtil.convert(req);
        return businessDomainValueObjectAttrMapper.insert(valueObjectAttrPO) == 1;
    }

    @Override
    public boolean update(DomainValueObjectAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainValueObjectAttr req) {
        BusinessDomainValueObjectAttrPO valueObjectAttrPO = DomainPOUtil.convert(req);
        return businessDomainValueObjectAttrMapper.delete(valueObjectAttrPO) == 1;
    }
}
