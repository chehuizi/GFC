package com.bmf.infrastructure.dal.utils;

import com.bmf.base.Business;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;

import java.util.ArrayList;
import java.util.List;
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
        businessPO.setBusinessPrefix(business.getBusinessPrefix());
        businessPO.setBusinessCode(business.getBusinessCode());
        businessPO.setBusinessName(business.getBusinessName());
        businessPO.setBusinessAlias(business.getBusinessAlias());
        businessPO.setBusinessDesc(business.getBusinessDesc());
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
        business.setBusinessPrefix(businessPO.getBusinessPrefix());
        business.setBusinessCode(businessPO.getBusinessCode());
        business.setBusinessName(businessPO.getBusinessName());
        business.setBusinessAlias(businessPO.getBusinessAlias());
        business.setBusinessDesc(businessPO.getBusinessDesc());
        return business;
    }

    /**
     * DO转PO
     * @param businessDomainRelation
     * @return
     */
    public static BusinessDomainRelationPO convert(BusinessDomainRelation businessDomainRelation) {
        BusinessDomainRelationPO businessDomainRelationPO = new BusinessDomainRelationPO();
        businessDomainRelationPO.setBusinessCode(businessDomainRelation.getBusinessCode());
        businessDomainRelationPO.setDomainRelation(businessDomainRelation.getDomainRelation());
        businessDomainRelationPO.setDomainACode(businessDomainRelation.getDomainACode());
        businessDomainRelationPO.setDomainARole(businessDomainRelation.getDomainARole());
        businessDomainRelationPO.setDomainBCode(businessDomainRelation.getDomainBCode());
        businessDomainRelationPO.setDomainBRole(businessDomainRelation.getDomainBRole());
        return businessDomainRelationPO;
    }

    /**
     * DO转PO
     * @param businessRelDomain
     * @return
     */
    public static BusinessRelDomainPO convert(BusinessRelDomain businessRelDomain) {
        BusinessRelDomainPO businessRelDomainPO = new BusinessRelDomainPO();
        businessRelDomainPO.setBusinessCode(businessRelDomain.getBusinessCode());
        businessRelDomainPO.setDomainCode(businessRelDomain.getDomainCode());
        return businessRelDomainPO;
    }

    /**
     * PO转DO
     * @param businessRelDomainPO
     * @return
     */
    public static BusinessRelDomain convert(BusinessRelDomainPO businessRelDomainPO) {
        BusinessRelDomain businessRelDomain = new BusinessRelDomain();
        businessRelDomain.setBusinessCode(businessRelDomainPO.getBusinessCode());
        businessRelDomain.setDomainCode(businessRelDomainPO.getDomainCode());
        return businessRelDomain;
    }

    /**
     * PO列表转DO列表
     * @param businessRelDomainPOList
     * @return
     */
    public static List<BusinessRelDomain> convert(List<BusinessRelDomainPO> businessRelDomainPOList) {
        if (Objects.isNull(businessRelDomainPOList) || businessRelDomainPOList.size() <= 0) {
            return null;
        }
        List<BusinessRelDomain> businessRelDomainList = new ArrayList<>();
        for (BusinessRelDomainPO item : businessRelDomainPOList) {
            businessRelDomainList.add(convert(item));
        }
        return businessRelDomainList;
    }

    /**
     * PO列表转DO列表
     * @param businessDomainRelationPOList
     * @return
     */
    public static List<BusinessDomainRelation> convertDR(List<BusinessDomainRelationPO> businessDomainRelationPOList) {
        if (Objects.isNull(businessDomainRelationPOList) || businessDomainRelationPOList.size() <= 0) {
            return null;
        }
        List<BusinessDomainRelation> businessDomainRelationList = new ArrayList<>();
        for (BusinessDomainRelationPO item : businessDomainRelationPOList) {
            businessDomainRelationList.add(convert(item));
        }
        return businessDomainRelationList;
    }

    /**
     * PO转DO
     * @param businessDomainRelationPO
     * @return
     */
    public static BusinessDomainRelation convert(BusinessDomainRelationPO businessDomainRelationPO) {
        BusinessDomainRelation businessDomainRelation = new BusinessDomainRelation();
        businessDomainRelation.setBusinessCode(businessDomainRelationPO.getBusinessCode());
        businessDomainRelation.setDomainRelation(businessDomainRelationPO.getDomainRelation());
        businessDomainRelation.setDomainACode(businessDomainRelationPO.getDomainACode());
        businessDomainRelation.setDomainARole(businessDomainRelationPO.getDomainARole());
        businessDomainRelation.setDomainBCode(businessDomainRelationPO.getDomainBCode());
        businessDomainRelation.setDomainBRole(businessDomainRelationPO.getDomainBRole());
        return businessDomainRelation;
    }
}
