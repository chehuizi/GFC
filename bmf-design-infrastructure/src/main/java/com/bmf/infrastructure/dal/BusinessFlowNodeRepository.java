package com.bmf.infrastructure.dal;

import com.bmf.base.flow.BusinessFlowNode;

import java.util.List;

public interface BusinessFlowNodeRepository extends BaseRepository<BusinessFlowNode> {

    /**
     * 查询流程节点列表
     * @param flowId
     * @return
     */
    List<BusinessFlowNode> selectNodeList(Integer flowId);
}
