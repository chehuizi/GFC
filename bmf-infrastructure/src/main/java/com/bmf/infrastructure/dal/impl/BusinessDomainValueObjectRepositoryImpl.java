package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;
import com.bmf.infrastructure.dal.BusinessDomainValueObjectRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainValueObjectMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainValueObjectRepositoryImpl implements BusinessDomainValueObjectRepository {

    @Resource
    private BusinessDomainValueObjectMapper businessDomainValueObjectMapper;

    @Override
    public BusinessDomainValueObjectPO selectOne(BusinessDomainValueObject req) {
        return null;
    }

    @Override
    public boolean insert(BusinessDomainValueObject req) {
        businessDomainValueObjectMapper.insert(DomainPOUtil.convert(req));
        return false;
    }

    @Override
    public boolean update(BusinessDomainValueObject req) {
        return false;
    }

    @Override
    public boolean delete(BusinessDomainValueObject req) {
        return false;
    }
}
