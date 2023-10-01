package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;

import java.util.List;

public interface BusinessRelDomainMapper {

    BusinessRelDomainPO selectOne(BusinessRelDomainPO businessRelDomainPO);

    List<BusinessRelDomainPO> selectByBusinessCode(Integer businessCode);

    int insert(BusinessRelDomainPO businessRelDomainPO);

    int batchInsert(List<BusinessRelDomainPO> businessRelDomainPOList);

    int update(BusinessRelDomainPO businessRelDomainPO);

    int batchUpdate(List<BusinessRelDomainPO> businessRelDomainPOList);

    int delete(BusinessRelDomainPO businessRelDomainPO);

    int batchDelete(List<BusinessRelDomainPO> businessRelDomainPOList);

    int deleteByBusinessCode(Integer businessCode);
}
