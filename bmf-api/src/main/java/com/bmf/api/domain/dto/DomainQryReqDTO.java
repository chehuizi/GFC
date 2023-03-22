package com.bmf.api.domain.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.aggregate.DomainAggregate;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域请求参数对象
 */
@Data
public class DomainQryReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 1781863846052662235L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 业务领域
     */
    private BusinessDomain businessDomain;
    /**
     * 包括领域实体
     */
    private boolean includeEntity;
    /**
     * 包括领域服务
     */
    private boolean includeService;
    /**
     * 包括领域事件
     */
    private boolean includeEvent;
}
