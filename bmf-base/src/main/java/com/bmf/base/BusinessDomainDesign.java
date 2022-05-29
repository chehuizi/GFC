package com.bmf.base;

import java.util.List;

/**
 * 业务设计
 */
public interface BusinessDomainDesign {

    /**
     * 战略设计
     */
    BusinessDomainMap design4Strategy(Business business);

    /**
     * 战术设计
     */
    List<BusinessDomain> design4Tactics(Business business);
}
