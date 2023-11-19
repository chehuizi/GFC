package com.bmf.design.core.flow;

import com.bmf.design.model.flow.BusinessFlow;

/**
 * 业务流程设计
 */
public interface BusinessFlowDesign {

    /**
     * 添加流程
     * @param businessFlow
     * @return
     */
    boolean addFlow(BusinessFlow businessFlow);

    /**
     * 更新流程
     * @param businessFlow
     * @return
     */
    boolean updateFlow(BusinessFlow businessFlow);

    /**
     * 查询流程
     * @param businessFlow
     * @return
     */
    BusinessFlow queryFlow(BusinessFlow businessFlow);

}
