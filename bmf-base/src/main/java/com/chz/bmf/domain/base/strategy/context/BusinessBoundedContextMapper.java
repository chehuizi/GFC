package com.chz.bmf.domain.base.strategy.context;

import com.chz.bmf.domain.base.meta.BusinessDomainContextMapperEnum;
import lombok.Data;

/**
 * 业务领域上下文映射关系
 */
@Data
public class BusinessBoundedContextMapper {

    /**
     * 上下文映射
     */
    private BusinessDomainContextMapperEnum contextMapperEnum;
    /**
     * A域
     */
    private BusinessBoundedContext domainA;
    /**
     * B域
     */
    private BusinessBoundedContext domainB;

}
