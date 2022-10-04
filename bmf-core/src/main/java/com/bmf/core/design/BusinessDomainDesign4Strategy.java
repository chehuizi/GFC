package com.bmf.core.design;

import com.bmf.base.strategy.BusinessDomainRelationship;

/**
 * 业务设计
 */
public interface BusinessDomainDesign4Strategy {

    /**
     * 构建领域关系
     * @param relationship
     * @return
     */
    boolean buildBusinessDomainRelationship(BusinessDomainRelationship relationship);

    /**
     * 移除领域关系
     * @param relationship
     * @return
     */
    boolean removeBusinessDomainRelationship(BusinessDomainRelationship relationship);
}
