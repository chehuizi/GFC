package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainMapper {

    DomainPO selectOne(DomainPO domainPO);

    List<DomainPO> selectByDomainCode(List<Integer> domainCodeList);

    int insert(DomainPO domainPO);

    int batchInsert(List<DomainPO> domainPOList);

    int update(DomainPO domainPO);

    int batchUpdate(List<DomainPO> domainPOList);

    int delete(DomainPO domainPO);

    int batchDelete(List<DomainPO> domainPOList);
}
