package com.chz.bmf.domain.base;

/**
 * 业务架构
 */
public interface BusinessArch {

    /**
     * 战略设计
     */
    BusinessDomain design4Strategy(Business business);

    /**
     * 战术设计
     */
    BusinessDomain design4Tactics(Business business);
}
