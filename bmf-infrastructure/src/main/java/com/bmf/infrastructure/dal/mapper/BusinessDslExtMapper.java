package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDslExtPO;

import java.util.List;

public interface BusinessDslExtMapper {

    BusinessDslExtPO selectOne(BusinessDslExtPO businessDslExtPO);

    int insert(BusinessDslExtPO businessDslExtPO);

    int batchInsert(List<BusinessDslExtPO> dslExtPOList);

    int update(BusinessDslExtPO businessDslExtPO);

    int delete(BusinessDslExtPO businessDslExtPO);
}
