package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainValueObjectPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainValueObjectMapper {

    DomainValueObjectPO selectOne(DomainValueObjectPO domainValueObjectPO);

    List<DomainValueObjectPO> selectByVoCode(@Param("voCodeList") List<Integer> voCodeList);

    int insert(DomainValueObjectPO domainValueObjectPO);

    int update(DomainValueObjectPO domainValueObjectPO);

    int delete(DomainValueObjectPO domainValueObjectPO);

}
