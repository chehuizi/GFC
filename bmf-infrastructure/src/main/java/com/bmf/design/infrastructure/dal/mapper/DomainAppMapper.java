package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainAppPO;

import java.util.List;

public interface DomainAppMapper {

    DomainAppPO selectOne(DomainAppPO domainAppPO);

    DomainAppPO selectByDomainCode(Integer domainCode);

    int insert(DomainAppPO domainAppPO);

    int batchInsert(List<DomainAppPO> domainAppPOList);

    int update(DomainAppPO domainAppPO);

    int delete(DomainAppPO domainAppPO);
}
