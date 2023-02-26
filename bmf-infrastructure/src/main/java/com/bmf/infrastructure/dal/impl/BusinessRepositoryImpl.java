package com.bmf.infrastructure.dal.impl;

import com.bmf.base.Business;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.mapper.BusinessMapper;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessRepositoryImpl implements BusinessRepository {

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public Business selectOne(Business req) {
        BusinessPO businessPO = POUtils.convert(req, BusinessPO.class);
        return POUtils.convert(businessMapper.selectOne(businessPO), Business.class);
    }

    @Override
    public boolean insert(Business req) {
        BusinessPO businessPO = POUtils.convert(req, BusinessPO.class);
        return businessMapper.insert(businessPO) == 1;
    }

    @Override
    public boolean update(Business req) {
        return false;
    }

    @Override
    public boolean delete(Business req) {
        return false;
    }
}
