package com.bmf.infrastructure.dal.impl;

import com.bmf.api.domain.DomainReqDTO;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.mapper.DomainMapper;
import com.bmf.infrastructure.dal.po.DomainPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;

import javax.annotation.Resource;

public class DomainRepositoryImpl implements DomainRepository {

    @Resource
    private DomainMapper domainMapper;

    @Override
    public DomainPO selectOne(DomainReqDTO req) {
        return domainMapper.selectOne(DomainPOUtil.convert(req));
    }

    @Override
    public boolean insert(DomainReqDTO req) {
        return domainMapper.insert(DomainPOUtil.convert(req)) > 0;
    }

    @Override
    public boolean update(DomainReqDTO req) {
        return domainMapper.update(DomainPOUtil.convert(req)) > 0;
    }

    @Override
    public boolean delete(DomainReqDTO req) {
        return domainMapper.delete(DomainPOUtil.convert(req)) > 0;
    }
}
