package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainAppPO;

import java.util.List;

public interface DomainAppMapper {

    DomainAppPO selectOne(DomainAppPO domainAppPO);

    int insert(DomainAppPO domainAppPO);

    int batchInsert(List<DomainAppPO> domainAppPOList);

    int update(DomainAppPO domainAppPO);

    int delete(DomainAppPO domainAppPO);
}
