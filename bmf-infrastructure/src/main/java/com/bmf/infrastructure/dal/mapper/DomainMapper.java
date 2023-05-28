package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainPO;

import java.util.List;

public interface DomainMapper {

    DomainPO selectOne(DomainPO domainPO);

    List<DomainPO> selectList(List<Integer> domainCodeList);

    int insert(DomainPO domainPO);

    int batchInsert(List<DomainPO> domainPOList);

    int update(DomainPO domainPO);

    int delete(DomainPO domainPO);
}
