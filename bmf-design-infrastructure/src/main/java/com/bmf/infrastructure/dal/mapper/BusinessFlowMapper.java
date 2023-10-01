package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessFlowPO;

public interface BusinessFlowMapper {

    BusinessFlowPO selectOne(BusinessFlowPO businessFlowPO);

    int insert(BusinessFlowPO businessFlowPO);

    int update(BusinessFlowPO businessFlowPO);

    int delete(BusinessFlowPO businessFlowPO);
}
