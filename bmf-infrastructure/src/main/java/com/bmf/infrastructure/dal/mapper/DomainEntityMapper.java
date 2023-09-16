package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainEntityPO;

import java.util.List;

public interface DomainEntityMapper {

    DomainEntityPO selectOne(DomainEntityPO domainEntityPO);

    List<DomainEntityPO> selectByDomainCode(Integer domainCode);

    int insert(DomainEntityPO domainEntityPO);

    int update(DomainEntityPO domainEntityPO);

    int delete(DomainEntityPO domainEntityPO);

}
