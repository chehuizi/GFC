package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEventPO;

import java.util.List;

public interface BusinessDomainEventMapper {

    BusinessDomainEventPO selectOne(BusinessDomainEventPO businessDomainEventPO);

    List<BusinessDomainEventPO> selectByDomainCode(Integer domainCode);

    int insert(BusinessDomainEventPO businessDomainEventPO);

    int update(BusinessDomainEventPO businessDomainEventPO);

    int delete(BusinessDomainEventPO businessDomainEventPO);

}
