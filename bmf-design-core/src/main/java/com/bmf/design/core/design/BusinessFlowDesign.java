package com.bmf.design.core.design;

import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.base.flow.BusinessFlowNode;

import java.util.List;

/**
 * 业务设计
 */
public interface BusinessFlowDesign {

    /**
     * 添加流程
     * @param businessFlow
     * @param businessFlowNode
     * @return
     */
    boolean addFlow(BusinessFlow businessFlow, BusinessFlowNode businessFlowNode);

    /**
     * 添加流程节点
     * @param businessFlowNode
     * @return
     */
    boolean addFlowNode(BusinessFlowNode businessFlowNode);

    /**
     * 查询流程
     * @param businessFlow
     * @return
     */
    BusinessFlow queryFlow(BusinessFlow businessFlow);

    /**
     * 查询流程节点
     * @param businessFlow
     * @return
     */
    List<BusinessFlowNode> queryFlowNode(BusinessFlow businessFlow);
}
