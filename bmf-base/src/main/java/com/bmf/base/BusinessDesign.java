package com.bmf.base;

import com.bmf.base.BusinessDomainMap;

import java.util.List;

/**
 * 业务设计
 */
public interface BusinessDesign {

    /**
     * 战略设计
     */
    BusinessDomainMap design4Strategy(Business business);

    /**
     * 战术设计
     */
    List<BusinessDomain> design4Tactics(Business business);
}
