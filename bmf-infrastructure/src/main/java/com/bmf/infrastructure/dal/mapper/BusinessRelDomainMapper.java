package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;

import java.util.List;

public interface BusinessRelDomainMapper {

    BusinessRelDomainPO selectOne(BusinessRelDomainPO businessRelDomainPO);

    List<BusinessRelDomainPO> selectList(BusinessRelDomainPO businessRelDomainPO);

    int insert(BusinessRelDomainPO businessRelDomainPO);

    int update(BusinessRelDomainPO businessRelDomainPO);

    int delete(BusinessRelDomainPO businessRelDomainPO);
}
