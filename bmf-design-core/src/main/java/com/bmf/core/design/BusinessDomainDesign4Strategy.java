package com.bmf.core.design;

import com.bmf.base.Business;
import com.bmf.base.strategy.DomainRelationship;

import java.util.List;

/**
 * 业务设计
 */
public interface BusinessDomainDesign4Strategy {

    /**
     * 构建领域关系
     * @param relationship
     * @return
     */
    boolean buildBusinessDomainRelationship(DomainRelationship relationship);

    /**
     * 批量构建领域关系
     * @param business
     * @param relationshipList
     * @return
     */
    boolean batchBuildBusinessDomainRelationship(Business business, List<DomainRelationship> relationshipList);

    /**
     * 移除领域关系
     * @param relationship
     * @return
     */
    boolean removeBusinessDomainRelationship(DomainRelationship relationship);
}
