package com.bmf.core.domain;

import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.event.DomainEventAttr;

import java.util.List;

/**
 * 领域事件服务
 */
public interface DomainEventService {

    /**
     * 根据领域编码查询事件列表
     * @param domainCode
     * @return
     */
    List<DomainEvent> queryByDomainCode(Integer domainCode);
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
