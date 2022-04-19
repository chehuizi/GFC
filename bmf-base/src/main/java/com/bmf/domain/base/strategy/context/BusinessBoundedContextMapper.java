package com.bmf.domain.base.strategy.context;

import com.bmf.domain.base.enums.BusinessBoundedContextMapperEnum;
import lombok.Data;

/**
 * 业务领域上下文映射关系
 */
@Data
public class BusinessBoundedContextMapper {

    /**
     * 上下文映射
     */
    private BusinessBoundedContextMapperEnum contextMapperEnum;
    /**
     * A域
     */
    private BusinessBoundedContext domainA;
    /**
     * B域
     */
    private BusinessBoundedContext domainB;

}
