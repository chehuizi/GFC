package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.service.DomainServiceAttr;
import com.bmf.infrastructure.dal.DomainServiceAttrRepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainServiceAttrMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainServiceAttrPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainServiceAttrRepositoryImpl implements DomainServiceAttrRepository {

    @Resource
    private BusinessDomainServiceAttrMapper businessDomainServiceAttrMapper;

    @Override
    public BusinessDomainServiceAttrPO selectOne(DomainServiceAttr req) {
        return null;
    }

    @Override
    public boolean insert(DomainServiceAttr req) {
        return false;
    }

    @Override
    public boolean update(DomainServiceAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainServiceAttr req) {
        return false;
    }
}
