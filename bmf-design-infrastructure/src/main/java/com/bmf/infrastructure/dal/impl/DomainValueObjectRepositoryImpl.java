package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.infrastructure.dal.DomainValueObjectRepository;
import com.bmf.infrastructure.dal.mapper.DomainValueObjectMapper;
import com.bmf.infrastructure.dal.po.DomainValueObjectPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainValueObjectRepositoryImpl implements DomainValueObjectRepository {

    @Autowired
    private DomainValueObjectMapper domainValueObjectMapper;

    @Override
    public DomainValueObject selectOne(DomainValueObject req) {
        DomainValueObjectPO domainValueObjectPO = POUtils.convert(req, DomainValueObjectPO.class);
        return POUtils.convert(domainValueObjectMapper.selectOne(domainValueObjectPO), DomainValueObject.class);
    }

    @Override
    public List<DomainValueObject> selectByVoCode(List<Integer> voCodeList) {
        return POUtils.convert(domainValueObjectMapper.selectByVoCode(voCodeList), DomainValueObject.class);
    }

    @Override
    public boolean insert(DomainValueObject req) {
        DomainValueObjectPO domainValueObjectPO = POUtils.convert(req, DomainValueObjectPO.class);
        return domainValueObjectMapper.insert(domainValueObjectPO) == 1;
    }

    @Override
    public boolean update(DomainValueObject req) {
        return false;
    }

    @Override
    public boolean delete(DomainValueObject req) {
        DomainValueObjectPO domainValueObjectPO = POUtils.convert(req, DomainValueObjectPO.class);
        return domainValueObjectMapper.delete(domainValueObjectPO) == 1;
    }
}
