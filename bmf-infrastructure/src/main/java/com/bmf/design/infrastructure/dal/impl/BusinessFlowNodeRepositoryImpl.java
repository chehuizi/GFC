package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.flow.BusinessFlowNode;
import com.bmf.design.infrastructure.dal.mapper.BusinessFlowNodeMapper;
import com.bmf.design.infrastructure.dal.po.BusinessFlowNodePO;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.BusinessFlowNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean batchInsert(List<BusinessFlowNode> nodeList) {
        List<BusinessFlowNodePO> businessFlowNodePOList = POUtils.convertModel2PO(nodeList, BusinessFlowNodePO.class);
        return businessFlowNodeMapper.batchInsert(businessFlowNodePOList) == nodeList.size();
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

    @Override
    public List<BusinessFlowNode> selectList(Integer flowId) {
        return POUtils.convert(businessFlowNodeMapper.selectList(flowId),
                BusinessFlowNode.class);
    }
}
