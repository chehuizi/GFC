package com.bmf.core.design;

import com.bmf.base.Business;
import com.bmf.base.flow.BusinessFlow;
import com.bmf.base.flow.BusinessFlowNode;

import java.util.List;

/**
 * 业务设计
 */
public interface BusinessFlowDesign {

    /**
     * 添加流程
     * @return
     */
    boolean addFlow(BusinessFlow businessFlow);

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
