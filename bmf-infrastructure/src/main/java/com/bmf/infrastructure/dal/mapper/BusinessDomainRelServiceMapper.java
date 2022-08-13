package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainRelServicePO;

public interface BusinessDomainRelServiceMapper {

    BusinessDomainRelServicePO selectOne(BusinessDomainRelServicePO businessDomainRelServicePO);

    int insert(BusinessDomainRelServicePO businessDomainRelServicePO);

    int update(BusinessDomainRelServicePO businessDomainRelServicePO);

    int delete(BusinessDomainRelServicePO businessDomainRelServicePO);

}
