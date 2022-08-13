package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEventPO;

public interface BusinessDomainEventMapper {

    BusinessDomainEventPO selectOne(BusinessDomainEventPO businessDomainEventPO);

    int insert(BusinessDomainEventPO businessDomainEventPO);

    int update(BusinessDomainEventPO businessDomainEventPO);

    int delete(BusinessDomainEventPO businessDomainEventPO);

}
