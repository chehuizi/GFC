package com.chz.bmf.domain.base.tactics.service;


import com.chz.bmf.domain.base.tactics.flow.engine.FlowEngine;
import com.chz.bmf.domain.base.meta.BusinessDomainNameEnum;
import lombok.Data;

@Data
public abstract class BusinessBaseService implements BusinessService {

    /**
     * 领域
     */
    private BusinessDomainNameEnum domainName;
    /**
     * 流程引擎
     */
    private FlowEngine flowEngine;

}
