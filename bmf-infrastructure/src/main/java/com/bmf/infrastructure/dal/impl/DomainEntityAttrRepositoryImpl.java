package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.infrastructure.dal.DomainEntityAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEntityAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityAttrPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainEntityAttrRepositoryImpl implements DomainEntityAttrRepository {

    @Resource
    private BusinessDomainEntityAttrMapper businessDomainEntityAttrMapper;

    @Override
    public DomainEntityAttr selectOne(DomainEntityAttr req) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = POUtils.convert(req, BusinessDomainEntityAttrPO.class);
        return POUtils.convert(businessDomainEntityAttrMapper.selectOne(domainEntityAttrPO), DomainEntityAttr.class);
    }

    @Override
    public boolean insert(DomainEntityAttr req) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = POUtils.convert(req, BusinessDomainEntityAttrPO.class);
        return businessDomainEntityAttrMapper.insert(domainEntityAttrPO) == 1;
    }

    @Override
    public boolean update(DomainEntityAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainEntityAttr req) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = POUtils.convert(req, BusinessDomainEntityAttrPO.class);
        return businessDomainEntityAttrMapper.delete(domainEntityAttrPO) == 1;
    }
}
