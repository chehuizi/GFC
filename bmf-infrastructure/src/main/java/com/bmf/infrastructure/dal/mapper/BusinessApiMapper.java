package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessApiPO;

import java.util.List;

public interface BusinessApiMapper {

    BusinessApiPO selectOne(BusinessApiPO businessApiPO);

    int insert(BusinessApiPO businessApiPO);

    int batchInsert(List<BusinessApiPO> businessApiPOList);

    int update(BusinessApiPO businessApiPO);

    int delete(BusinessApiPO businessApiPO);
}
