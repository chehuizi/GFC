package com.bmf.design.core.design.impl;

import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.base.flow.BusinessFlowNode;
import com.bmf.design.core.design.BusinessFlowDesign;
import com.bmf.design.infrastructure.dal.BusinessFlowNodeRepository;
import com.bmf.design.infrastructure.dal.BusinessFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusinessFlowDesignImpl implements BusinessFlowDesign {

    @Autowired
    private BusinessFlowRepository businessFlowRepository;
    @Autowired
    private BusinessFlowNodeRepository businessFlowNodeRepository;

    @Override
    @Transactional
    public boolean addFlow(BusinessFlow businessFlow, BusinessFlowNode businessFlowNode) {
        boolean insertFlow = businessFlowRepository.insert(businessFlow);
        if (insertFlow) {
            return businessFlowNodeRepository.insert(businessFlowNode);
        }
        return false;
    }

    @Override
    public boolean addFlowNode(BusinessFlowNode businessFlowNode) {
        return businessFlowNodeRepository.insert(businessFlowNode);
    }

    @Override
    public BusinessFlow queryFlow(BusinessFlow businessFlow) {
        return businessFlowRepository.selectOne(businessFlow);
    }

    @Override
    public List<BusinessFlowNode> queryFlowNode(BusinessFlow businessFlow) {
        return businessFlowNodeRepository.selectNodeList(businessFlow.getFlowId());
    }
}
