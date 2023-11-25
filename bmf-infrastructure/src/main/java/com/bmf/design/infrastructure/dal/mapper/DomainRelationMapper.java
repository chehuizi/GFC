package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainRelationPO;

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
