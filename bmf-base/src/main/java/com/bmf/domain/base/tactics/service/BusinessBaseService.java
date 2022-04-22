package com.bmf.domain.base.tactics.service;


import com.bmf.domain.base.tactics.flow.engine.FlowEngine;
import lombok.Data;

@Data
public abstract class BusinessBaseService implements BusinessService {

    /**
     * 领域
     */
    private String domainName;
    /**
     * 流程引擎
     */
    private FlowEngine flowEngine;

}
