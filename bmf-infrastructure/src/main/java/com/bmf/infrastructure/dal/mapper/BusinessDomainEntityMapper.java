package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEntityPO;

import java.util.List;

public interface BusinessDomainEntityMapper {

    BusinessDomainEntityPO selectOne(BusinessDomainEntityPO businessDomainEntityPO);

    List<BusinessDomainEntityPO> selectByDomainCode(Integer domainCode);

    int insert(BusinessDomainEntityPO businessDomainEntityPO);

    int update(BusinessDomainEntityPO businessDomainEntityPO);

    int delete(BusinessDomainEntityPO businessDomainEntityPO);

}
