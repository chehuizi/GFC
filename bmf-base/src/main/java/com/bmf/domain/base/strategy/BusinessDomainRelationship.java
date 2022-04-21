package com.bmf.domain.base.strategy;

import com.bmf.domain.base.BusinessDomain;

/**
 * 业务域关系
 */
public class BusinessDomainRelationship {

    /**
     * 关系
     * @see com.bmf.domain.base.enums.RelationshipEnum
     */
    private String relationship;
    /**
     * 领域A
     */
    private BusinessDomain domainA;
    /**
     * 领域B
     */
    private BusinessDomain domainB;
}
