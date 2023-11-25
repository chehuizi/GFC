package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.tactics.service.DomainServiceAttr;
import com.bmf.design.infrastructure.dal.mapper.DomainServiceAttrMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainServiceAttrRepository;
import com.bmf.design.infrastructure.dal.po.DomainServiceAttrPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceAttrRepositoryImpl implements DomainServiceAttrRepository {

    @Autowired
    private DomainServiceAttrMapper domainServiceAttrMapper;

    @Override
    public DomainServiceAttr selectOne(DomainServiceAttr req) {
        return null;
    }

    @Override
    public List<DomainServiceAttr> selectByServiceCode(Integer serviceCode) {
        return POUtils.convert(domainServiceAttrMapper.selectByServiceCode(serviceCode), DomainServiceAttr.class);
    }

    @Override
    public boolean insert(DomainServiceAttr req) {
        DomainServiceAttrPO serviceAttrPO = POUtils.convert(req, DomainServiceAttrPO.class);
        return domainServiceAttrMapper.insert(serviceAttrPO) == 1;
    }

    @Override
    public boolean update(DomainServiceAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainServiceAttr req) {
        DomainServiceAttrPO serviceAttrPO = POUtils.convert(req, DomainServiceAttrPO.class);
        return domainServiceAttrMapper.delete(serviceAttrPO) == 1;
    }
}
