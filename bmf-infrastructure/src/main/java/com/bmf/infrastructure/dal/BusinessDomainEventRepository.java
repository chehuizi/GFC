package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.event.BusinessDomainEvent;
import com.bmf.infrastructure.dal.po.BusinessDomainEventPO;

public interface BusinessDomainEventRepository extends BaseRepository<BusinessDomainEvent, BusinessDomainEventPO> {

}