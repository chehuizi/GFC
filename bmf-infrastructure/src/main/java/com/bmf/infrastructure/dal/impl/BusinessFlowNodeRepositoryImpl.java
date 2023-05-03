package com.bmf.infrastructure.dal.impl;

import com.bmf.base.flow.BusinessFlowNode;
import com.bmf.infrastructure.dal.BusinessFlowNodeRepository;
import com.bmf.infrastructure.dal.mapper.BusinessFlowNodeMapper;
import com.bmf.infrastructure.dal.po.BusinessFlowNodePO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessFlowNodeRepositoryImpl implements BusinessFlowNodeRepository {

    @Autowired
    private BusinessFlowNodeMapper businessFlowNodeMapper;

    @Override
    public BusinessFlowNode selectOne(BusinessFlowNode req) {
        BusinessFlowNodePO businessFlowNodePO = POUtils.convert(req, BusinessFlowNodePO.class);
        return POUtils.convert(businessFlowNodeMapper.selectOne(businessFlowNodePO), BusinessFlowNode.class);
    }

    @Override
    public boolean insert(BusinessFlowNode req) {
        BusinessFlowNodePO businessFlowNodePO = POUtils.convert(req, BusinessFlowNodePO.class);
        return businessFlowNodeMapper.insert(businessFlowNodePO) == 1;
    }

    @Override
    public boolean update(BusinessFlowNode req) {
        BusinessFlowNodePO businessFlowNodePO = POUtils.convert(req, BusinessFlowNodePO.class);
        return businessFlowNodeMapper.update(businessFlowNodePO) == 1;
    }

    @Override
    public boolean delete(BusinessFlowNode req) {
        BusinessFlowNodePO businessFlowNodePO = POUtils.convert(req, BusinessFlowNodePO.class);
        return businessFlowNodeMapper.delete(businessFlowNodePO) == 1;
    }
}
