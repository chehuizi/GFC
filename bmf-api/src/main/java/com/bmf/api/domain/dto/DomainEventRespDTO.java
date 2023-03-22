package com.bmf.api.domain.dto;

import com.bmf.api.RespDTO;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.event.DomainEventAttr;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 领域事件返回对象
 */
@Data
@NoArgsConstructor
public class DomainEventRespDTO extends RespDTO implements Serializable {

    /**
     * 领域事件
     */
    private DomainEvent domainEvent;
    /**
     * 事件属性列表
     */
    private List<DomainEventAttr> eventAttrList;
}
