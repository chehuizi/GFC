package com.bmf.design.api.domain.dto;

import com.bmf.design.api.ReqDTO;
import com.bmf.design.base.tactics.event.DomainEvent;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域事件qry请求对象
 */
@Data
public class DomainEventQryReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -2540955012551918707L;

    /**
     * 领域事件
     */
    private DomainEvent domainEvent;
    /**
     * 包含事件属性
     */
    private boolean includeAttr;

}
