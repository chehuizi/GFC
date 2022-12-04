package com.bmf.api.business.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.strategy.BusinessDomainRelationship;
import lombok.Data;

import java.io.Serializable;

/**
 * 业务请求对象
 */
@Data
public class BusinessReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 1324200904629702741L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 领域
     */
    private BusinessDomain domain;
    /**
     * 领域关系
     */
    private BusinessDomainRelationship relationship;
    /**
     * 包含领域
     */
    private boolean includeDomain;
}
