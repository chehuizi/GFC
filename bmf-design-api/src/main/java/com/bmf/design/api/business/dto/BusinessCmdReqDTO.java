package com.bmf.design.api.business.dto;

import com.bmf.design.api.ReqDTO;
import com.bmf.design.base.Business;
import com.bmf.design.base.Domain;
import com.bmf.design.base.flow.BusinessRole;
import com.bmf.design.base.strategy.DomainRelationship;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 业务请求对象
 */
@Data
public class BusinessCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 1324200904629702741L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 领域
     */
    private Domain domain;
    /**
     * 领域列表
     */
    private List<Domain> domainList;
    /**
     * 领域关系
     */
    private DomainRelationship relationship;
    /**
     * 领域关系列表
     */
    private List<DomainRelationship> relationshipList;
    /**
     * 角色
     */
    private BusinessRole businessRole;
}
