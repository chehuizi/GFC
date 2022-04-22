package com.bmf.domain.base;

import java.util.List;

/**
 * 业务
 */
public class Business implements BusinessDomainDesign {

    @Override
    public BusinessDomainMap design4Strategy(List<BusinessDomain> domainList) {
        return null;
    }

    @Override
    public BusinessDomain design4Tactics(BusinessDomain domain) {
        return null;
    }
}
