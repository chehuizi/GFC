package com.bmf.design.core.domain;

import com.bmf.design.model.tactics.event.DomainEvent;
import com.bmf.design.model.tactics.event.DomainEventAttr;

import java.util.List;

/**
 * 领域事件服务
 */
public interface DomainEventService {

    /**
     * 查询领域事件
     * @param domainEvent
     * @return
     */
    DomainEvent queryDomainEvent(DomainEvent domainEvent);

    /**
     * 根据领域编码查询事件列表
     * @param domainCode
     * @return
     */
    List<DomainEvent> queryByDomainCode(Integer domainCode);

    /**
     * 根据事件code查询事件属性
     * @param eventCode
     * @return
     */
    List<DomainEventAttr> queryEventAttr(Integer eventCode);

    /**
     * 添加事件属性
     * @param eventAttr
     * @return
     */
    Boolean addEventAttr(DomainEventAttr eventAttr);

    /**
     * 删除事件属性
     * @param eventAttr
     * @return
     */
    Boolean delEventAttr(DomainEventAttr eventAttr);
}
