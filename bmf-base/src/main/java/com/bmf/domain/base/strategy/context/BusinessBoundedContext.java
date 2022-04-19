package com.bmf.domain.base.strategy.context;

import com.bmf.domain.base.enums.BusinessDomainNameEnum;
import lombok.Data;

/**
 * 业务领域上下文
 */
@Data
public class BusinessBoundedContext {

    private BusinessDomainNameEnum domainNameEnum;

}
