package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainServicePO;

import java.util.List;

public interface BusinessDomainServiceMapper {

    BusinessDomainServicePO selectOne(BusinessDomainServicePO businessDomainServicePO);

    List<BusinessDomainServicePO> selectByDomainCode(Integer domainCode);

    int insert(BusinessDomainServicePO businessDomainServicePO);

    int update(BusinessDomainServicePO businessDomainServicePO);

    int delete(BusinessDomainServicePO businessDomainServicePO);

}
