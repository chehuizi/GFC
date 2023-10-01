package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.infrastructure.dal.DomainEntityAttrRepository;
import com.bmf.infrastructure.dal.mapper.DomainEntityAttrMapper;
import com.bmf.infrastructure.dal.po.DomainEntityAttrPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEntityAttrRepositoryImpl implements DomainEntityAttrRepository {

    @Autowired
    private DomainEntityAttrMapper domainEntityAttrMapper;

    @Override
    public DomainEntityAttr selectOne(DomainEntityAttr req) {
        DomainEntityAttrPO domainEntityAttrPO = POUtils.convert(req, DomainEntityAttrPO.class);
        return POUtils.convert(domainEntityAttrMapper.selectOne(domainEntityAttrPO), DomainEntityAttr.class);
    }

    @Override
    public List<DomainEntityAttr> selectByEntityIdCode(Integer entityIdCode) {
        return POUtils.convert(domainEntityAttrMapper.selectByEntityIdCode(entityIdCode), DomainEntityAttr.class);
    }

    @Override
    public boolean insert(DomainEntityAttr req) {
        DomainEntityAttrPO domainEntityAttrPO = POUtils.convert(req, DomainEntityAttrPO.class);
        return domainEntityAttrMapper.insert(domainEntityAttrPO) == 1;
    }

    @Override
    public boolean update(DomainEntityAttr req) {
        return false;
    }

    @Override
    public boolean delete(DomainEntityAttr req) {
        DomainEntityAttrPO domainEntityAttrPO = POUtils.convert(req, DomainEntityAttrPO.class);
        return domainEntityAttrMapper.delete(domainEntityAttrPO) == 1;
    }
}
