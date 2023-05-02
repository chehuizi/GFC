package com.bmf.core.design.impl;

import com.bmf.base.flow.BusinessFlow;
import com.bmf.base.flow.BusinessFlowNode;
import com.bmf.core.design.BusinessFlowDesign;
import com.bmf.infrastructure.dal.BusinessFlowNodeRepository;
import com.bmf.infrastructure.dal.BusinessFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessFlowDesignImpl implements BusinessFlowDesign {

    @Autowired
    private BusinessFlowRepository businessFlowRepository;
    @Autowired
    private BusinessFlowNodeRepository businessFlowNodeRepository;

    @Override
    public boolean addFlow(BusinessFlow businessFlow) {
        return businessFlowRepository.insert(businessFlow);
    }

    @Override
    public boolean addFlowNode(BusinessFlowNode businessFlowNode) {
        return businessFlowNodeRepository.insert(businessFlowNode);
    }

    @Override
    public BusinessFlow queryFlow(BusinessFlow businessFlow) {
        return businessFlowRepository.selectOne(businessFlow);
    }
}
