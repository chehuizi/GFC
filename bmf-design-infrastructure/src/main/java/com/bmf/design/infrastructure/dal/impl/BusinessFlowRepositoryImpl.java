package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.infrastructure.dal.mapper.BusinessFlowMapper;
import com.bmf.design.infrastructure.dal.po.BusinessFlowPO;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.BusinessFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessFlowRepositoryImpl implements BusinessFlowRepository {

    @Autowired
    private BusinessFlowMapper businessFlowMapper;

    @Override
    public BusinessFlow selectOne(BusinessFlow req) {
        BusinessFlowPO businessFlowPO = POUtils.convert(req, BusinessFlowPO.class);
        return POUtils.convert(businessFlowMapper.selectOne(businessFlowPO), BusinessFlow.class);
    }

    @Override
    public boolean insert(BusinessFlow req) {
        BusinessFlowPO businessFlowPO = POUtils.convert(req, BusinessFlowPO.class);
        return businessFlowMapper.insert(businessFlowPO) == 1;
    }

    @Override
    public boolean update(BusinessFlow req) {
        BusinessFlowPO businessFlowPO = POUtils.convert(req, BusinessFlowPO.class);
        return businessFlowMapper.update(businessFlowPO) == 1;
    }

    @Override
    public boolean delete(BusinessFlow req) {
        BusinessFlowPO businessFlowPO = POUtils.convert(req, BusinessFlowPO.class);
        return businessFlowMapper.delete(businessFlowPO) == 1;
    }
}
