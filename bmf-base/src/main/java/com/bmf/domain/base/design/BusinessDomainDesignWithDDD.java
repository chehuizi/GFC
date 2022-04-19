package com.bmf.domain.base.design;

import com.bmf.domain.base.Business;
import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.BusinessDomainDesign;
import com.bmf.domain.base.BusinessDomainMap;
import com.bmf.domain.base.strategy.BusinessDomainInStrategy;
import com.bmf.domain.base.tactics.BusinessDomainInTactics;

/**
 * DDD业务架构
 */
public class BusinessDomainDesignWithDDD implements BusinessDomainDesign {

    @Override
    public BusinessDomainMap design4Strategy(Business business) {
        BusinessDomainMap businessDomainMap = new BusinessDomainMap();
        return businessDomainMap;
    }

    @Override
    public BusinessDomain design4Tactics(BusinessDomain businessDomain) {
        BusinessDomainInTactics domainInTactics = new BusinessDomainInTactics();
        return domainInTactics;
    }
}
