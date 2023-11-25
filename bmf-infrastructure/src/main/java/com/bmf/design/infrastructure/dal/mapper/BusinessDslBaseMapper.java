package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.BusinessDslBasePO;

public interface BusinessDslBaseMapper {

    BusinessDslBasePO selectOne(BusinessDslBasePO businessDslBasePO);

    int insert(BusinessDslBasePO businessDslBasePO);

    int update(BusinessDslBasePO businessDslBasePO);

    int delete(BusinessDslBasePO businessDslBasePO);
}
