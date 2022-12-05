package com.bmf.base;

import lombok.Data;

@Data
public class BusinessDomainRelation extends BaseDO {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域关系
     * @see com.bmf.base.enums.RelationshipEnum
     */
    private String domainRelation;
    /**
     * 领域A角色
     */
    private String domainARole;
    /**
     * 领域A编码
     */
    private Integer domainACode;
    /**
     * 领域B角色
     */
    private String domainBRole;
    /**
     * 领域B编码
     */
    private Integer domainBCode;
}
