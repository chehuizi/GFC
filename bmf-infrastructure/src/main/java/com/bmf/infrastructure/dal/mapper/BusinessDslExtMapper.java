package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDslExtPO;

public interface BusinessDslExtMapper {

    BusinessDslExtPO selectOne(BusinessDslExtPO businessDslExtPO);

    int insert(BusinessDslExtPO businessDslExtPO);

    int update(BusinessDslExtPO businessDslExtPO);

    int delete(BusinessDslExtPO businessDslExtPO);
}
