package com.bmf.design.core.utils;

import com.bmf.design.base.Business;
import com.bmf.design.base.Domain;
import com.bmf.design.base.DomainRelation;
import com.bmf.design.base.BusinessRelDomain;
import com.bmf.design.base.strategy.DomainRelationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public static BusinessRelDomain convert(Business business, Domain domain) {
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
    public static DomainRelation convertDR(Business business) {
        DomainRelation domainRelation = new DomainRelation();
        domainRelation.setBusinessCode(business.getBusinessCode());
        return domainRelation;
    }

    /**
     * 转换对象
     * @param business
     * @param domain
     * @return
     */
    public static DomainRelation convertDR(Business business, Domain domain) {
        DomainRelation domainRelation = new DomainRelation();
        domainRelation.setBusinessCode(business.getBusinessCode());
        domainRelation.setDomainACode(domain.getDomainCode());
        domainRelation.setDomainBCode(domain.getDomainCode());
        return domainRelation;
    }

    /**
     * 转换对象
     * @param business
     * @param domainRelationship
     * @return
     */
    public static DomainRelation convert(Business business, DomainRelationship domainRelationship) {
        if (Objects.isNull(domainRelationship)) {
            return null;
        }
        DomainRelation domainRelation = new DomainRelation();
        domainRelation.setBusinessCode(Objects.nonNull(business) ? business.getBusinessCode()
                : domainRelationship.getBusinessCode());
        domainRelation.setDomainRelation(domainRelationship.getRelationship());
        domainRelation.setDomainACode(domainRelationship.getRoleA().getDomain().getDomainCode());
        domainRelation.setDomainARole(domainRelationship.getRoleA().getRole());
        domainRelation.setDomainBCode(domainRelationship.getRoleB().getDomain().getDomainCode());
        domainRelation.setDomainBRole(domainRelationship.getRoleB().getRole());
        return domainRelation;
    }

    /**
     * 转换对象列表
     * @param business
     * @param relationshipList
     * @return
     */
    public static List<DomainRelation> convert(Business business, List<DomainRelationship> relationshipList) {
        if (relationshipList.isEmpty()) {
            return null;
        }
        List<DomainRelation> domainRelationList = new ArrayList<>();
        for (DomainRelationship item : relationshipList) {
            domainRelationList.add(convert(business, item));
        }
        return domainRelationList;
    }
}
