package com.bmf.design.base.flow;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.flow.node.EndFlowNode;
import com.bmf.design.base.flow.node.StartFlowNode;
import lombok.Data;

import java.util.List;

/**
 * 业务流程
 */
@Data
public class BusinessFlow extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 流程ID
     */
    private Integer flowId;
    /**
     * 流程名称（中文）
     */
    private String flowName;
    /**
     * 流程别名（英文）
     */
    private String flowAlias;
    /**
     * 开始节点
     */
    private StartFlowNode startNode;
    /**
     * 中间节点列表
     */
    private List<BusinessFlowNode> midNodeList;
    /**
     * 结束节点
     */
    private EndFlowNode endNode;
    /**
     * 流程线列表
     */
    private List<BusinessFlowLine> flowLineList;

}
