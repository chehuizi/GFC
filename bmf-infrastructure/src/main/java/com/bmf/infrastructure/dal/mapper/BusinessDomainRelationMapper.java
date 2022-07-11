package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;

public interface BusinessDomainRelationMapper {

    BusinessDomainRelationPO selectOne(BusinessDomainRelationPO businessDomainRelationPO);

    int insert(BusinessDomainRelationPO businessDomainRelationPO);

    int update(BusinessDomainRelationPO businessDomainRelationPO);

    int delete(BusinessDomainRelationPO businessDomainRelationPO);
}
