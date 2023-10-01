package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainValueObjectAttrPO;

public interface DomainValueObjectAttrMapper {

    DomainValueObjectAttrPO selectOne(DomainValueObjectAttrPO domainValueObjectAttrPO);

    int insert(DomainValueObjectAttrPO domainValueObjectAttrPO);

    int update(DomainValueObjectAttrPO domainValueObjectAttrPO);

    int delete(DomainValueObjectAttrPO domainValueObjectAttrPO);

}
