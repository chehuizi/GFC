package com.bmf.infrastructure.dal.impl;

import com.bmf.base.DO.DomainRelEntityDO;
import com.bmf.infrastructure.dal.BusinessDomainRelEntityRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainRelEntityMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainRelEntityPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainRelEntityRepositoryImpl implements BusinessDomainRelEntityRepository {

    @Resource
    private BusinessDomainRelEntityMapper businessDomainRelEntityMapper;

    @Override
    public BusinessDomainRelEntityPO selectOne(DomainRelEntityDO req) {
        return null;
    }

    @Override
    public boolean insert(DomainRelEntityDO req) {
        BusinessDomainRelEntityPO domainRelEntityPO = DomainPOUtil.convert(req);
        return businessDomainRelEntityMapper.insert(domainRelEntityPO) == 1;
    }

    @Override
    public boolean update(DomainRelEntityDO req) {
        return false;
    }

    @Override
    public boolean delete(DomainRelEntityDO req) {
        return false;
    }
}
