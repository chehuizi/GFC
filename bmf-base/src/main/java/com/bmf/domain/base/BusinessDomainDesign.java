package com.bmf.domain.base;

/**
 * 业务架构
 */
public interface BusinessDomainDesign {

    /**
     * 战略设计
     */
    BusinessDomainMap design4Strategy(Business business);

    /**
     * 战术设计
     */
    BusinessDomain design4Tactics(BusinessDomain business);
}
