package com.bmf.domain.base;

import com.bmf.domain.base.strategy.BusinessDomainRelationship;

import java.util.List;

/**
 * 业务域映射
 */
public class BusinessDomainMap {

    /**
     * 业务域列表
     */
    private List<BusinessDomain> domainList;

    /**
     * 业务域关系列表
     */
    private List<BusinessDomainRelationship> domainRelationshipList;
}
