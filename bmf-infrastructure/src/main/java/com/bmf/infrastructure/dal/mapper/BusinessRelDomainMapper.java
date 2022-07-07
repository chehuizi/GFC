package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;

public interface BusinessRelDomainMapper {

    BusinessRelDomainPO selectOne(BusinessRelDomainPO businessRelDomainPO);

    int insert(BusinessRelDomainPO businessRelDomainPO);

    int update(BusinessRelDomainPO businessRelDomainPO);

    int delete(BusinessRelDomainPO businessRelDomainPO);
}
