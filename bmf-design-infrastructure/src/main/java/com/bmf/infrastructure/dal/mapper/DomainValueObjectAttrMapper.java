package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainValueObjectAttrPO;

public interface DomainValueObjectAttrMapper {

    DomainValueObjectAttrPO selectOne(DomainValueObjectAttrPO domainValueObjectAttrPO);

    int insert(DomainValueObjectAttrPO domainValueObjectAttrPO);

    int update(DomainValueObjectAttrPO domainValueObjectAttrPO);

    int delete(DomainValueObjectAttrPO domainValueObjectAttrPO);

}
