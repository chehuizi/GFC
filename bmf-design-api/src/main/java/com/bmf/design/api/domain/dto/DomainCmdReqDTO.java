package com.bmf.design.api.domain.dto;

import com.bmf.common.api.ReqDTO;
import com.bmf.design.model.Business;
import com.bmf.design.model.Domain;
import com.bmf.design.model.dsl.BusinessDslBase;
import com.bmf.design.model.tactics.aggregate.DomainAggregate;
import com.bmf.design.model.tactics.entity.DomainEntity;
import com.bmf.design.model.tactics.event.DomainEvent;
import com.bmf.design.model.tactics.service.DomainService;
import com.bmf.design.model.tactics.valueobject.DomainValueObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域请求对象
 */
@Data
public class DomainCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -8692914722346528072L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 业务域
     */
    private Domain domain;
    /**
     * 业务实体
     */
    private DomainEntity domainEntity;
    /**
     * 值对象
     */
    private DomainValueObject domainValueObject;
    /**
     * 聚合根
     */
    private DomainAggregate domainAggregate;
    /**
     * 领域服务
     */
    private DomainService domainService;
    /**
     * 领域事件
     */
    private DomainEvent domainEvent;
    /**
     * DSL
     */
    private BusinessDslBase dslBase;
}
