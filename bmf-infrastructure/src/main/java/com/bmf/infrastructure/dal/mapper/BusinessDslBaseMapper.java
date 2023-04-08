package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDslBasePO;

public interface BusinessDslBaseMapper {

    BusinessDslBasePO selectOne(BusinessDslBasePO businessDslBasePO);

    int insert(BusinessDslBasePO businessDslBasePO);

    int update(BusinessDslBasePO businessDslBasePO);

    int delete(BusinessDslBasePO businessDslBasePO);
}
