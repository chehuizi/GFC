package com.bmf.core.design.impl;

import com.bmf.base.flow.BusinessFlow;
import com.bmf.core.design.BusinessFlowDesign;
import com.bmf.infrastructure.dal.BusinessFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessFlowDesignImpl implements BusinessFlowDesign {

    @Autowired
    private BusinessFlowRepository businessFlowRepository;

    @Override
    public boolean addFlow(BusinessFlow businessFlow) {
        return businessFlowRepository.insert(businessFlow);
    }
}
