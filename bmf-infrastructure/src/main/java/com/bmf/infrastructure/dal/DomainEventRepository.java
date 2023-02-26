package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.infrastructure.dal.po.BusinessDomainEventPO;

public interface DomainEventRepository extends BaseRepository<DomainEvent, DomainEvent> {

}