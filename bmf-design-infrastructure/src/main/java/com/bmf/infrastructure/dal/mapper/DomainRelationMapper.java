package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainRelationPO;

import java.util.List;

public interface DomainRelationMapper {

    DomainRelationPO selectOne(DomainRelationPO domainRelationPO);

    List<DomainRelationPO> selectByBusinessCode(Integer businessCode);

    List<DomainRelationPO> selectByDomain(DomainRelationPO domainRelationPO);

    int insert(DomainRelationPO domainRelationPO);

    int batchInsert(List<DomainRelationPO> domainRelationPOList);

    int update(DomainRelationPO domainRelationPO);

    int delete(DomainRelationPO domainRelationPO);

    int deleteByBusinessCode(Integer businessCode);
}
