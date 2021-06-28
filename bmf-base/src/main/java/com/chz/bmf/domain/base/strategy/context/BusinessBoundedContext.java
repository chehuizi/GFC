package com.chz.bmf.domain.base.strategy.context;

import com.chz.bmf.domain.base.meta.BusinessDomainNameEnum;
import lombok.Data;

/**
 * 业务领域上下文
 */
@Data
public class BusinessBoundedContext {

    private BusinessDomainNameEnum domainNameEnum;

}
