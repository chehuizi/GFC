package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.BusinessFlowNodePO;

import java.util.List;

public interface BusinessFlowNodeMapper {

    BusinessFlowNodePO selectOne(BusinessFlowNodePO businessFlowNodePO);

    int insert(BusinessFlowNodePO businessFlowNodePO);

    int batchInsert(List<BusinessFlowNodePO> businessFlowNodePOList);

    int update(BusinessFlowNodePO businessFlowNodePO);

    int delete(BusinessFlowNodePO businessFlowNodePO);

    List<BusinessFlowNodePO> selectList(Integer flowId);
}
