package com.bmf.design;

import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;

/**
 * 业务设计
 */
public interface BusinessDomainDesign4Strategy {

    /**
     * 构建领域关系
     */
    boolean buildBusinessDomainRelationship(Business business, BusinessDomain domainA, BusinessDomain domainB);
}
