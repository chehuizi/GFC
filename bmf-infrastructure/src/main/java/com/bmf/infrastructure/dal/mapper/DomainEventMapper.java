package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainEventPO;

import java.util.List;

public interface DomainEventMapper {

    DomainEventPO selectOne(DomainEventPO domainEventPO);

    List<DomainEventPO> selectByDomainCode(Integer domainCode);

    int insert(DomainEventPO domainEventPO);

    int update(DomainEventPO domainEventPO);

    int delete(DomainEventPO domainEventPO);

}
