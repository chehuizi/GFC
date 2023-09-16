package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainApiPO;

import java.util.List;

public interface DomainApiMapper {

    DomainApiPO selectOne(DomainApiPO domainApiPO);

    int insert(DomainApiPO domainApiPO);

    int batchInsert(List<DomainApiPO> domainApiPOList);

    int update(DomainApiPO domainApiPO);

    int delete(DomainApiPO domainApiPO);
}
