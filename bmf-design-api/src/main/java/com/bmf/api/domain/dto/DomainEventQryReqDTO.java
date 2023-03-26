package com.bmf.api.domain.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.event.DomainEventAttr;
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
