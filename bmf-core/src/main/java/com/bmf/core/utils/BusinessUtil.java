package com.bmf.core.utils;

import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;
import com.bmf.base.strategy.BusinessDomainRelationship;

public class BusinessUtil {

    /**
     * 转换对象
     * @param business
     * @return
     */
    public static BusinessRelDomain convert(Business business) {
        BusinessRelDomain businessRelDomain = new BusinessRelDomain();
        businessRelDomain.setBusinessCode(business.getBusinessCode());
        return businessRelDomain;
    }

    /**
     * 转换对象
     * @param business
     * @param domain
     * @return
     */
    public static BusinessRelDomain convert(Business business, BusinessDomain domain) {
        BusinessRelDomain businessRelDomain = new BusinessRelDomain();
        businessRelDomain.setBusinessCode(business.getBusinessCode());
        businessRelDomain.setDomainCode(domain.getDomainCode());
        return businessRelDomain;
    }

    /**
     * 转换对象
     * @param business
     * @return
     */
    public static BusinessDomainRelation convertDR(Business business) {
        BusinessDomainRelation businessDomainRelation = new BusinessDomainRelation();
        businessDomainRelation.setBusinessCode(business.getBusinessCode());
        return businessDomainRelation;
    }

    /**
     * 转换对象
     * @param business
     * @param domain
     * @return
     */
    public static BusinessDomainRelation convertDR(Business business, BusinessDomain domain) {
        BusinessDomainRelation businessDomainRelation = new BusinessDomainRelation();
        businessDomainRelation.setBusinessCode(business.getBusinessCode());
        businessDomainRelation.setDomainACode(domain.getDomainCode());
        businessDomainRelation.setDomainBCode(domain.getDomainCode());
        return businessDomainRelation;
    }

    /**
     * 转换对象
     * @param businessDomainRelationship
     * @return
     */
    public static BusinessDomainRelation convert(BusinessDomainRelationship businessDomainRelationship) {
        BusinessDomainRelation businessDomainRelation = new BusinessDomainRelation();
        businessDomainRelation.setBusinessCode(businessDomainRelationship.getBusinessCode());
        businessDomainRelation.setDomainRelation(businessDomainRelationship.getRelationship());
        businessDomainRelation.setDomainACode(businessDomainRelationship.getRoleA().getDomain().getDomainCode());
        businessDomainRelation.setDomainARole(businessDomainRelationship.getRoleA().getRole());
        businessDomainRelation.setDomainBCode(businessDomainRelationship.getRoleB().getDomain().getDomainCode());
        businessDomainRelation.setDomainBRole(businessDomainRelationship.getRoleB().getRole());
        return businessDomainRelation;
    }
}
