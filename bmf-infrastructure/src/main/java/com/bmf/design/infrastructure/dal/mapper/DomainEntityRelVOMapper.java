package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainEntityRelVOPO;

import java.util.List;

public interface DomainEntityRelVOMapper {

    DomainEntityRelVOPO selectOne(DomainEntityRelVOPO domainEntityRelVOPO);

    List<DomainEntityRelVOPO> selectByEntityIdCode(Integer entityIdCode);

    int insert(DomainEntityRelVOPO domainEntityRelVOPO);

    int update(DomainEntityRelVOPO domainEntityRelVOPO);

    int delete(DomainEntityRelVOPO domainEntityRelVOPO);

}
