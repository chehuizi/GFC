package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEntityPO;

public interface BusinessDomainEntityMapper {

    BusinessDomainEntityPO selectOne(BusinessDomainEntityPO businessDomainEntityPO);

    int insert(BusinessDomainEntityPO businessDomainEntityPO);

    int update(BusinessDomainEntityPO businessDomainEntityPO);

    int delete(BusinessDomainEntityPO businessDomainEntityPO);

}
