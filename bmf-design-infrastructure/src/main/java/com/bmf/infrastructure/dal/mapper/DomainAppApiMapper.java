package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainAppApiPO;

import java.util.List;

public interface DomainAppApiMapper {

    DomainAppApiPO selectOne(DomainAppApiPO domainAppApiPO);

    List<DomainAppApiPO> selectByDomainCode(Integer domainCode);

    int insert(DomainAppApiPO domainAppApiPO);

    int batchInsert(List<DomainAppApiPO> domainAppApiPOList);

    int update(DomainAppApiPO domainAppApiPO);

    int delete(DomainAppApiPO domainAppApiPO);
}
