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
     * 业务域
     */
    private BusinessDomain businessDomain;
}
