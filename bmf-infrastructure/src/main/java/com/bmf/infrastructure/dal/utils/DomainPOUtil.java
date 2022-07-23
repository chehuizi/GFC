package com.bmf.infrastructure.dal.utils;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityAttrPO;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityPO;
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

    public static BusinessDomainEntityPO convert(BusinessDomainEntity businessDomainEntity) {
        BusinessDomainEntityPO domainEntityPO = new BusinessDomainEntityPO();
        domainEntityPO.setEntityIdCode(businessDomainEntity.getEntityIdCode());
        domainEntityPO.setEntityIdName(businessDomainEntity.getEntityIdName());
        domainEntityPO.setEntityIdType(businessDomainEntity.getEntityIdType());
        return domainEntityPO;
    }

    public static BusinessDomainEntityAttrPO convert(DomainEntityAttr domainEntityAttr) {
        BusinessDomainEntityAttrPO domainEntityAttrPO = new BusinessDomainEntityAttrPO();
        domainEntityAttrPO.setEntityIdCode(domainEntityAttr.getEntityIdCode());
        domainEntityAttrPO.setAttrName(domainEntityAttr.getAttrName());
        domainEntityAttrPO.setAttrType(domainEntityAttr.getAttrType());
        domainEntityAttrPO.setAttrDesc(domainEntityAttr.getAttrDesc());
        return domainEntityAttrPO;
    }
}
