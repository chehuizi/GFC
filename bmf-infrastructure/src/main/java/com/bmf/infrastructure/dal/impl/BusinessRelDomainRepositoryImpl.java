package com.bmf.infrastructure.dal.impl;

import com.bmf.base.BusinessRelDomain;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.mapper.BusinessRelDomainMapper;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessRelDomainRepositoryImpl implements BusinessRelDomainRepository {

    @Resource
    private BusinessRelDomainMapper businessRelDomainMapper;

    @Override
    public BusinessRelDomain selectOne(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return POUtils.convert(businessRelDomainMapper.selectOne(businessRelDomainPO), BusinessRelDomain.class);
    }

    @Override
    public List<BusinessRelDomainPO> selectList(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return businessRelDomainMapper.selectList(businessRelDomainPO);
    }

    @Override
    public boolean insert(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return businessRelDomainMapper.insert(businessRelDomainPO) == 1;
    }

    @Override
    public boolean update(BusinessRelDomain req) {
        return false;
    }

    @Override
    public boolean delete(BusinessRelDomain req) {
        BusinessRelDomainPO businessRelDomainPO = POUtils.convert(req, BusinessRelDomainPO.class);
        return businessRelDomainMapper.delete(businessRelDomainPO) == 1;
    }
}
