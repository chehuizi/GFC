package com.bmf.infrastructure.dal.utils;

import com.bmf.base.Business;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.po.BusinessPO;

import java.util.Objects;

/**
 * PO工具类
 */
public class BusinessPOUtil {

    /**
     * DO转PO
     * @param business
     * @return
     */
    public static BusinessPO convert(Business business) {
        BusinessPO businessPO = new BusinessPO();
        businessPO.setBusinessCode(business.getBusinessCode());
        businessPO.setBusinessName(business.getBusinessName());
        return businessPO;
    }

    /**
     * PO转DO
     * @param businessPO
     * @return
     */
    public static Business convert(BusinessPO businessPO) {
        if (Objects.isNull(businessPO)) {
            return null;
        }
        Business business = new Business();
        business.setBusinessCode(businessPO.getBusinessCode());
        business.setBusinessName(businessPO.getBusinessName());
        return business;
    }

    /**
     * DO转PO
     * @param businessDomainRelationship
     * @return
     */
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
