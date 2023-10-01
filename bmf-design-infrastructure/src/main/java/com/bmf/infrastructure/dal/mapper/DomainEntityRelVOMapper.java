package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainEntityRelVOPO;

import java.util.List;

public interface DomainEntityRelVOMapper {

    DomainEntityRelVOPO selectOne(DomainEntityRelVOPO domainEntityRelVOPO);

    List<DomainEntityRelVOPO> selectByEntityIdCode(Integer entityIdCode);

    int insert(DomainEntityRelVOPO domainEntityRelVOPO);

    int update(DomainEntityRelVOPO domainEntityRelVOPO);

    int delete(DomainEntityRelVOPO domainEntityRelVOPO);

}
