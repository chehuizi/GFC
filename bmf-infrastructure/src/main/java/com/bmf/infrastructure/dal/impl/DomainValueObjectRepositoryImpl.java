package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.infrastructure.dal.DomainValueObjectRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainValueObjectMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainValueObjectRepositoryImpl implements DomainValueObjectRepository {

    @Autowired
    private BusinessDomainValueObjectMapper businessDomainValueObjectMapper;

    @Override
    public DomainValueObject selectOne(DomainValueObject req) {
        BusinessDomainValueObjectPO domainValueObjectPO = POUtils.convert(req, BusinessDomainValueObjectPO.class);
        return POUtils.convert(businessDomainValueObjectMapper.selectOne(domainValueObjectPO), DomainValueObject.class);
    }

    @Override
    public List<DomainValueObject> selectByVoCode(List<Integer> voCodeList) {
        return POUtils.convert(businessDomainValueObjectMapper.selectByVoCode(voCodeList), DomainValueObject.class);
    }

    @Override
    public boolean insert(DomainValueObject req) {
        BusinessDomainValueObjectPO domainValueObjectPO = POUtils.convert(req, BusinessDomainValueObjectPO.class);
        return businessDomainValueObjectMapper.insert(domainValueObjectPO) == 1;
    }

    @Override
    public boolean update(DomainValueObject req) {
        return false;
    }

    @Override
    public boolean delete(DomainValueObject req) {
        BusinessDomainValueObjectPO domainValueObjectPO = POUtils.convert(req, BusinessDomainValueObjectPO.class);
        return businessDomainValueObjectMapper.delete(domainValueObjectPO) == 1;
    }
}
