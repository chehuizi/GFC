package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainServicePO;

public interface BusinessDomainServiceMapper {

    BusinessDomainServicePO selectOne(BusinessDomainServicePO businessDomainServicePO);

    int insert(BusinessDomainServicePO businessDomainServicePO);

    int update(BusinessDomainServicePO businessDomainServicePO);

    int delete(BusinessDomainServicePO businessDomainServicePO);

}
