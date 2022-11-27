package com.bmf.api.domain;

import com.bmf.api.ReqDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.aggregate.BusinessDomainAggregate;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.base.tactics.event.BusinessDomainEvent;
import com.bmf.base.tactics.service.BusinessDomainService;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域请求对象
 */
@Data
public class DomainReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -8692914722346528072L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 业务域
     */
    private BusinessDomain businessDomain;
    /**
     * 业务实体
     */
    private BusinessDomainEntity domainEntity;
    /**
     * 值对象
     */
    private BusinessDomainValueObject domainValueObject;
    /**
     * 聚合根
     */
    private BusinessDomainAggregate domainAggregate;
    /**
     * 领域服务
     */
    private BusinessDomainService domainService;
    /**
     * 领域事件
     */
    private BusinessDomainEvent domainEvent;
}
