package com.bmf.base.design;

import com.bmf.base.Business;
import com.bmf.base.BusinessDesign;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainMap;

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
