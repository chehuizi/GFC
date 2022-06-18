package com.bmf.infrastructure.dal.impl;

import com.bmf.api.business.BusinessReqDTO;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.mapper.BusinessMapper;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.utils.BusinessPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessRepositoryImpl implements BusinessRepository {

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public BusinessPO selectOne(BusinessReqDTO req) {
        return null;
    }

    @Override
    public boolean insert(BusinessReqDTO req) {
        return businessMapper.insert(BusinessPOUtil.convert(req)) == 1;
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
