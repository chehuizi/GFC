package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

import java.util.Date;

@Data
public class DomainRelationPO extends BasePO {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域关系
     */
    private String domainRelation;
    /**
     * 领域A编码
     */
    private Integer domainACode;
    /**
     * 领域B编码
     */
    private Integer domainBCode;
    /**
     * 领域A角色
     */
    private String domainARole;
    /**
     * 领域B角色
     */
    private String domainBRole;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModify;
}
