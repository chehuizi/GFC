package com.bmf.infrastructure.dal.utils;

import com.bmf.base.BusinessDomain;
import com.bmf.infrastructure.dal.po.DomainPO;

public class DomainPOUtil {

    public static DomainPO convert(BusinessDomain businessDomain) {
        DomainPO domainPO = new DomainPO();
        domainPO.setDomainCode(businessDomain.getDomainCode());
        domainPO.setDomainName(businessDomain.getDomainName());
        domainPO.setDomainType(businessDomain.getDomainType());
        domainPO.setDomainLevel(businessDomain.getDomainLevel());
        return domainPO;
    }

    public static BusinessDomain convert(DomainPO domainPO) {
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(domainPO.getDomainCode());
        businessDomain.setDomainName(domainPO.getDomainName());
        businessDomain.setDomainType(domainPO.getDomainType());
        businessDomain.setDomainLevel(domainPO.getDomainLevel());
        return businessDomain;
    }
}
