package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;

import java.util.List;

public interface BusinessDomainRelationMapper {

    BusinessDomainRelationPO selectOne(BusinessDomainRelationPO businessDomainRelationPO);

    List<BusinessDomainRelationPO> selectList(BusinessDomainRelationPO businessDomainRelationPO);

    List<BusinessDomainRelationPO> selectByDomain(BusinessDomainRelationPO businessDomainRelationPO);

    int insert(BusinessDomainRelationPO businessDomainRelationPO);

    int batchInsert(List<BusinessDomainRelationPO> businessDomainRelationPOList);

    int update(BusinessDomainRelationPO businessDomainRelationPO);

    int delete(BusinessDomainRelationPO businessDomainRelationPO);

    int deleteByBusinessCode(Integer businessCode);
}
