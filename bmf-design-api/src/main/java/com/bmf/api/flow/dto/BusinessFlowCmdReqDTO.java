package com.bmf.api.flow.dto;

import com.bmf.api.ReqDTO;
import com.bmf.base.Business;
import com.bmf.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.base.enums.DomainElementEnum;
import com.bmf.base.flow.BusinessFlow;
import com.bmf.base.flow.BusinessFlowNode;
import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessFlowCmdReqDTO extends ReqDTO implements Serializable {

    private static final long serialVersionUID = -2692178052647653883L;

    /**
     * 业务
     */
    private Business business;
    /**
     * 业务流程
     */
    private BusinessFlow businessFlow;
    /**
     * 流程节点
     */
    private BusinessFlowNode businessFlowNode;

    /**
     * 初始化start节点
     */
    public void initStartNode() {
        businessFlowNode = new BusinessFlowNode();
        businessFlowNode.setFlowId(businessFlow.getFlowId());
        businessFlowNode.setNodeAlias(BusinessFlowNodeTypeEnum.START.getType());
        businessFlowNode.setNodeName(BusinessFlowNodeTypeEnum.START.getDesc());
        businessFlowNode.setNodeType(BusinessFlowNodeTypeEnum.START.getType());
        businessFlowNode.setDomainElement(DomainElementEnum.NONE.getElement());
    }
}
