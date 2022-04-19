package com.bmf.domain.base.strategy;

import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.strategy.context.BusinessBoundedContext;
import com.bmf.domain.base.strategy.context.BusinessBoundedContextMapper;
import lombok.Data;

import java.util.List;

/**
 * 领域战略设计
 */
@Data
public class BusinessDomainInStrategy extends BusinessDomain {

    /**
     * 界限上下文列表
     */
    private List<BusinessBoundedContext> contextList;
    /**
     * 界限上下文映射列表
     */
    private List<BusinessBoundedContextMapper> contextMapperList;

}
