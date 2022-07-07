package com.bmf.infrastructure.dal.impl;

import com.bmf.api.business.BusinessReqDTO;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.mapper.BusinessRelDomainMapper;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessRelDomainRepositoryImpl implements BusinessRelDomainRepository {

    @Resource
    private BusinessRelDomainMapper businessRelDomainMapper;

    @Override
    public BusinessRelDomainPO selectOne(BusinessReqDTO req) {
        return businessRelDomainMapper.selectOne(null);
    }

    @Override
    public boolean insert(BusinessReqDTO req) {
        return businessRelDomainMapper.insert(null) == 1;
    }

    @Override
    public boolean update(BusinessReqDTO req) {
        return false;
    }

    @Override
    public boolean delete(BusinessReqDTO req) {
        return false;
    }
}
