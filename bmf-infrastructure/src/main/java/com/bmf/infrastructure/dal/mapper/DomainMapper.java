package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainPO;

public interface DomainMapper {

    DomainPO selectOne(DomainPO domainPO);

    int insert(DomainPO domainPO);

    int update(DomainPO domainPO);

    int delete(DomainPO domainPO);
}
