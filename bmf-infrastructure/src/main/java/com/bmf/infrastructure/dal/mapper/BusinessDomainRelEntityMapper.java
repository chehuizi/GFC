package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainRelEntityPO;

public interface BusinessDomainRelEntityMapper {

    BusinessDomainRelEntityPO selectOne(BusinessDomainRelEntityPO businessDomainRelEntityPO);

    int insert(BusinessDomainRelEntityPO businessDomainRelEntityPO);

    int update(BusinessDomainRelEntityPO businessDomainRelEntityPO);

    int delete(BusinessDomainRelEntityPO businessDomainRelEntityPO);

}
