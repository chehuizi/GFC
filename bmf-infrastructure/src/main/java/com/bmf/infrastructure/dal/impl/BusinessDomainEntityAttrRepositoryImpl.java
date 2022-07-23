package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.infrastructure.dal.BusinessDomainEntityAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEntityAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityAttrPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainEntityAttrRepositoryImpl implements BusinessDomainEntityAttrRepository {

    @Resource
    private BusinessDomainEntityAttrMapper businessDomainEntityAttrMapper;

    @Override
    public BusinessDomainEntityAttrPO selectOne(DomainEntityAttr req) {
        return businessDomainEntityAttrMapper.selectOne(null);
    }

    @Override
    public boolean insert(DomainEntityAttr req) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = DomainPOUtil.convert(req);
        businessDomainEntityAttrMapper.insert(null);
        return false;
    }

    @Override
    public boolean update(DomainEntityAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainEntityAttr req) {
        return false;
    }
}
