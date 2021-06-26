package com.chz.bmf.domain.base.strategy;

import com.chz.bmf.domain.base.BusinessDomain;
import com.chz.bmf.domain.base.strategy.context.BusinessDomainContext;
import com.chz.bmf.domain.base.strategy.context.BusinessDomainContextMapper;
import lombok.Data;

import java.util.List;

/**
 * 领域战略设计
 */
@Data
public class BusinessDomainInStrategy extends BusinessDomain {

    /**
     * 上下文列表
     */
    private List<BusinessDomainContext> contextList;
    /**
     * 上下文映射列表
     */
    private List<BusinessDomainContextMapper> contextMapperList;

}
