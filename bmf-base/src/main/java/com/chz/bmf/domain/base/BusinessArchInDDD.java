package com.chz.bmf.domain.base;

import com.chz.bmf.domain.base.strategy.BusinessDomainInStrategy;
import com.chz.bmf.domain.base.tactics.BusinessDomainInTactics;

/**
 * DDD业务架构
 */
public class BusinessArchInDDD implements BusinessArch {

    @Override
    public BusinessDomain design4Strategy(Business business) {
        BusinessDomainInStrategy domainInStrategy = new BusinessDomainInStrategy();
        return domainInStrategy;
    }

    @Override
    public BusinessDomain design4Tactics(Business business) {
        BusinessDomainInTactics domainInTactics = new BusinessDomainInTactics();
        return domainInTactics;
    }
}
