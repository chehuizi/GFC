package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainMapper {

    DomainPO selectOne(DomainPO domainPO);

    List<DomainPO> selectByDomainCode(List<Integer> domainCodeList);

    List<DomainPO> selectByDomainAlias(@Param("businessCode") Integer businessCode,
                                       @Param("domainAliasList") List<String> domainAliasList);

    int insert(DomainPO domainPO);

    int batchInsert(List<DomainPO> domainPOList);

    int update(DomainPO domainPO);

    int delete(DomainPO domainPO);
}
