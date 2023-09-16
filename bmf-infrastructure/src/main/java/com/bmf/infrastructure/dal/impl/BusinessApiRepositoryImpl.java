package com.bmf.infrastructure.dal.impl;

import com.bmf.base.application.DomainApi;
import com.bmf.infrastructure.dal.BusinessApiRepository;
import com.bmf.infrastructure.dal.mapper.BusinessApiMapper;
import com.bmf.infrastructure.dal.po.BusinessApiPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessApiRepositoryImpl implements BusinessApiRepository {

    @Autowired
    private BusinessApiMapper businessApiMapper;

    @Override
    public DomainApi selectOne(DomainApi req) {
        return null;
    }

    @Override
    public boolean insert(DomainApi req) {
        return false;
    }

    @Override
    public boolean batchInsert(List<DomainApi> req) {
        List<BusinessApiPO> businessApiPOList = POUtils.convertModel2PO(req, BusinessApiPO.class);
        return businessApiMapper.batchInsert(businessApiPOList) == req.size();
    }

    @Override
    public boolean update(DomainApi req) {
        return false;
    }

    @Override
    public boolean delete(DomainApi req) {
        return false;
    }
}
