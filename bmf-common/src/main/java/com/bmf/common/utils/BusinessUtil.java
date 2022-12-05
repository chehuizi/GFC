package com.bmf.common.utils;

import com.bmf.api.business.dto.BusinessReqDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.base.strategy.BusinessDomainRelationship;

public class BusinessUtil {

    public static Business convert(BusinessReqDTO reqDTO) {
        Business business = new Business();
        business.setBusinessCode(reqDTO.getBusiness().getBusinessCode());
        business.setBusinessName(reqDTO.getBusiness().getBusinessName());
        return business;
    }

    public static BusinessRelDomainDO convertBusinessRelDomainDO(BusinessReqDTO businessReqDTO) {
        BusinessRelDomainDO businessRelDomainDO = new BusinessRelDomainDO();
        businessRelDomainDO.setBusinessCode(businessReqDTO.getBusiness().getBusinessCode());
        businessRelDomainDO.setDomainCode(businessReqDTO.getDomain().getDomainCode());
        return businessRelDomainDO;
    }

    /**
     * 转换对象
     * @param business
     * @return
     */
    public static BusinessRelDomainDO convert(Business business) {
        BusinessRelDomainDO businessRelDomainDO = new BusinessRelDomainDO();
        businessRelDomainDO.setBusinessCode(business.getBusinessCode());
        return businessRelDomainDO;
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
