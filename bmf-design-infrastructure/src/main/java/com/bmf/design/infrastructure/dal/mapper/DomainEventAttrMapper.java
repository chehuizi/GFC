package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainEventAttrPO;

import java.util.List;

public interface DomainEventAttrMapper {

    DomainEventAttrPO selectOne(DomainEventAttrPO domainEventAttrPO);

    List<DomainEventAttrPO> selectByEventCode(Integer eventCode);

    int insert(DomainEventAttrPO domainEventAttrPO);

    int update(DomainEventAttrPO domainEventAttrPO);

    int delete(DomainEventAttrPO domainEventAttrPO);

}
