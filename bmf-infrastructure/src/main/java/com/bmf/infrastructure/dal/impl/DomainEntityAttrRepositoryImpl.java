package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.infrastructure.dal.DomainEntityAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEntityAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityAttrPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainEntityAttrRepositoryImpl implements DomainEntityAttrRepository {

    @Resource
    private BusinessDomainEntityAttrMapper businessDomainEntityAttrMapper;

    @Override
    public BusinessDomainEntityAttrPO selectOne(DomainEntityAttr req) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = DomainPOUtil.convert(req, BusinessDomainEntityAttrPO.class);
        return businessDomainEntityAttrMapper.selectOne(domainEntityAttrPO);
    }

    @Override
    public boolean insert(DomainEntityAttr req) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = DomainPOUtil.convert(req, BusinessDomainEntityAttrPO.class);
        return businessDomainEntityAttrMapper.insert(domainEntityAttrPO) == 1;
    }

    @Override
    public boolean update(DomainEntityAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainEntityAttr req) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = DomainPOUtil.convert(req, BusinessDomainEntityAttrPO.class);
        return businessDomainEntityAttrMapper.delete(domainEntityAttrPO) == 1;
    }
}
