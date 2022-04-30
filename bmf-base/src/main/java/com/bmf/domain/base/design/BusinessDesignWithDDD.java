package com.bmf.domain.base.design;

import com.bmf.domain.base.Business;
import com.bmf.domain.base.BusinessDesign;
import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.BusinessDomainMap;

import java.util.List;

/**
 * DDD业务设计
 */
public class BusinessDesignWithDDD implements BusinessDesign {

    @Override
    public BusinessDomainMap design4Strategy(Business business) {
        return null;
    }

    @Override
    public List<BusinessDomain> design4Tactics(Business business) {
        return null;
    }
}
