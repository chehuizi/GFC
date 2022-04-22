package com.bmf.domain.base;

import java.util.List;

/**
 * 业务架构
 */
public interface BusinessDomainDesign {

    /**
     * 战略设计
     */
    BusinessDomainMap design4Strategy(List<BusinessDomain> domainList);

    /**
     * 战术设计
     */
    BusinessDomain design4Tactics(BusinessDomain domain);
}
