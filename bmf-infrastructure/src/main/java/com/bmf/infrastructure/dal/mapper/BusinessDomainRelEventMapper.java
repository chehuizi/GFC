package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainRelEventPO;

public interface BusinessDomainRelEventMapper {

    BusinessDomainRelEventPO selectOne(BusinessDomainRelEventPO businessDomainRelEventPO);

    int insert(BusinessDomainRelEventPO businessDomainRelEventPO);

    int update(BusinessDomainRelEventPO businessDomainRelEventPO);

    int delete(BusinessDomainRelEventPO businessDomainRelEventPO);

}
