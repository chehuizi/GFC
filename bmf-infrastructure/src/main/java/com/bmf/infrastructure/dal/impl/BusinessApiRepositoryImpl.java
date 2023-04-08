package com.bmf.infrastructure.dal.impl;

import com.bmf.base.application.BusinessApi;
import com.bmf.infrastructure.dal.BusinessApiRepository;
import com.bmf.infrastructure.dal.mapper.BusinessApiMapper;
import com.bmf.infrastructure.dal.po.BusinessApiPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessApiRepositoryImpl implements BusinessApiRepository {

    @Resource
    private BusinessApiMapper businessApiMapper;

    @Override
    public BusinessApi selectOne(BusinessApi req) {
        return null;
    }

    @Override
    public boolean insert(BusinessApi req) {
        return false;
    }

    @Override
    public boolean batchInsert(List<BusinessApi> req) {
        List<BusinessApiPO> businessApiPOList = POUtils.convertModel2PO(req, BusinessApiPO.class);
        return businessApiMapper.batchInsert(businessApiPOList) == req.size();
    }

    @Override
    public boolean update(BusinessApi req) {
        return false;
    }

    @Override
    public boolean delete(BusinessApi req) {
        return false;
    }
}
