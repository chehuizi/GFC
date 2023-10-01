package com.bmf.design.infrastructure.dal;

import com.bmf.design.base.tactics.event.DomainEventAttr;

import java.util.List;

public interface DomainEventAttrRepository extends BaseRepository<DomainEventAttr> {

    /**
     * 根据事件code查询事件属性
     * @param eventCode
     * @return
     */
    List<DomainEventAttr> selectByEventCode(Integer eventCode);
}