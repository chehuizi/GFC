package com.bmf.design.infrastructure.dal;

import com.bmf.design.model.flow.BusinessFlowNode;

import java.util.List;

public interface BusinessFlowNodeRepository extends BaseRepository<BusinessFlowNode> {

    /**
     * 查询流程节点列表
     * @param flowId
     * @return
     */
    List<BusinessFlowNode> selectList(Integer flowId);

    /**
     * 批量插入
     * @param nodeList
     * @return
     */
    boolean batchInsert(List<BusinessFlowNode> nodeList);
}
