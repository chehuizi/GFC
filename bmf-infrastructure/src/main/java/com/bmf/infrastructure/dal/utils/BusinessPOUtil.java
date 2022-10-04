package com.bmf.infrastructure.dal.utils;

import com.bmf.base.Business;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.po.BusinessPO;

/**
 * 工具类
 */
public class BusinessPOUtil {

    /**
     * 转换DO到PO
     * @param business
     * @return
     */
    public static BusinessPO convert(Business business) {
        BusinessPO businessPO = new BusinessPO();
        businessPO.setBusinessCode(business.getBusinessCode());
        businessPO.setBusinessName(business.getBusinessName());
        return businessPO;
    }

    public static Business convert(BusinessPO businessPO) {
        Business business = new Business();
        business.setBusinessCode(businessPO.getBusinessCode());
        business.setBusinessName(businessPO.getBusinessName());
        return business;
    }

    public static BusinessDomainRelationPO convert(BusinessDomainRelationship businessDomainRelationship) {
        BusinessDomainRelationPO businessDomainRelationPO = new BusinessDomainRelationPO();
        businessDomainRelationPO.setBusinessCode(businessDomainRelationship.getBusinessCode());
        businessDomainRelationPO.setDomainRelation(businessDomainRelationship.getRelationship());
        businessDomainRelationPO.setDomainACode(businessDomainRelationship.getRoleA().getDomain().getDomainCode());
        businessDomainRelationPO.setDomainARole(businessDomainRelationship.getRoleA().getRole());
        businessDomainRelationPO.setDomainBCode(businessDomainRelationship.getRoleB().getDomain().getDomainCode());
        businessDomainRelationPO.setDomainBRole(businessDomainRelationship.getRoleB().getRole());
        return businessDomainRelationPO;
    }
}
