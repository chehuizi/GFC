package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.event.DomainEvent;

import java.util.List;

public interface DomainEventRepository extends BaseRepository<DomainEvent> {

    /**
     * 根据领域编码查询事件列表
     * @param domainCode
     * @return
     */
    List<DomainEvent> selectByDomainCode(Integer domainCode);

}