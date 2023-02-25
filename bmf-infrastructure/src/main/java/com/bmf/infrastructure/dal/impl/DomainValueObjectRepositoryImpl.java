package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.infrastructure.dal.DomainValueObjectRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainValueObjectMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainValueObjectRepositoryImpl implements DomainValueObjectRepository {

    @Resource
    private BusinessDomainValueObjectMapper businessDomainValueObjectMapper;

    @Override
    public BusinessDomainValueObjectPO selectOne(DomainValueObject req) {
        BusinessDomainValueObjectPO domainValueObjectPO = DomainPOUtil.convert(req);
        return businessDomainValueObjectMapper.selectOne(domainValueObjectPO);
    }

    @Override
    public boolean insert(DomainValueObject req) {
        BusinessDomainValueObjectPO domainValueObjectPO = DomainPOUtil.convert(req);
        return businessDomainValueObjectMapper.insert(domainValueObjectPO) == 1;
    }

    @Override
    public boolean update(DomainValueObject req) {
        return false;
    }

    @Override
    public boolean delete(DomainValueObject req) {
        BusinessDomainValueObjectPO domainValueObjectPO = DomainPOUtil.convert(req);
        return businessDomainValueObjectMapper.delete(domainValueObjectPO) == 1;
    }
}
