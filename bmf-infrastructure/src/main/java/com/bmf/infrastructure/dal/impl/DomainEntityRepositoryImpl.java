package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.infrastructure.dal.DomainEntityRepository;
import com.bmf.infrastructure.dal.mapper.DomainEntityMapper;
import com.bmf.infrastructure.dal.po.DomainEntityPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEntityRepositoryImpl implements DomainEntityRepository {

    @Autowired
    private DomainEntityMapper domainEntityMapper;

    @Override
    public DomainEntity selectOne(DomainEntity req) {
        DomainEntityPO domainEntityPO = POUtils.convert(req, DomainEntityPO.class);
        return POUtils.convert(domainEntityMapper.selectOne(domainEntityPO), DomainEntity.class);
    }

    @Override
    public List<DomainEntity> selectByDomainCode(Integer domainCode) {
        return POUtils.convert(domainEntityMapper.selectByDomainCode(domainCode), DomainEntity.class);
    }

    @Override
    public boolean insert(DomainEntity req) {
        DomainEntityPO domainEntityPO = POUtils.convert(req, DomainEntityPO.class);
        return domainEntityMapper.insert(domainEntityPO) == 1;
    }

    @Override
    public boolean update(DomainEntity req) {
        return false;
    }

    @Override
    public boolean delete(DomainEntity req) {
        DomainEntityPO domainEntityPO = POUtils.convert(req, DomainEntityPO.class);
        return domainEntityMapper.delete(domainEntityPO) == 1;
    }
}
