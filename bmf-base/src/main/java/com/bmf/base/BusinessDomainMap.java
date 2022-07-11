package com.bmf.base;

import com.bmf.base.strategy.BusinessDomainRelationship;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务域映射
 */
@Data
public class BusinessDomainMap extends BaseDO {

    /**
     * 业务域列表
     */
    private List<BusinessDomain> domainList;

    /**
     * 业务域关系列表
     */
    private List<BusinessDomainRelationship> domainRelationshipList;

    public BusinessDomainMap() {
        domainList = new ArrayList<>();
        domainRelationshipList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "{" +
                "\"domainList\": " + domainList +
                ", \"domainRelationshipList\": " + domainRelationshipList +
                "}";
    }

    /**
     * 添加业务域
     * @param domain
     * @return
     */
    public boolean addBusinessDomain(BusinessDomain domain) {
        return domainList.add(domain);
    }

    /**
     * 添加业务域关系
     * @param domainRelationship
     * @return
     */
    public boolean addBusinessDomainRelationship(BusinessDomainRelationship domainRelationship) {
        return domainRelationshipList.add(domainRelationship);
    }
}
