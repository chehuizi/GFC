package com.bmf.api.domain.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.event.DomainEventAttr;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import lombok.Data;

import java.io.Serializable;

/**
 * 领域事件请求对象
 */
@Data
public class DomainEventCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = 118824266913896116L;
    /**
     * 领域事件
     */
    private DomainEvent domainEvent;
    /**
     * 事件属性
     */
    private DomainEventAttr eventAttr;
}
