package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessFlowNodePO;

public interface BusinessFlowNodeMapper {

    BusinessFlowNodePO selectOne(BusinessFlowNodePO businessFlowNodePO);

    int insert(BusinessFlowNodePO businessFlowNodePO);

    int update(BusinessFlowNodePO businessFlowNodePO);

    int delete(BusinessFlowNodePO businessFlowNodePO);
}
