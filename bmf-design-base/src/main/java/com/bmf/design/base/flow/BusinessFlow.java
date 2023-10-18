package com.bmf.design.base.flow;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.flow.node.EndFlowNode;
import com.bmf.design.base.flow.node.StartFlowNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
     * 场景ID
     */
    private Integer sceneId;
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

    public void addStartNode(StartFlowNode startFlowNode) {
        this.setStartNode(startFlowNode);
    }

    /**
     * 添加中间节点
     * @param flowNode
     */
    public void addMidNode(BusinessFlowNode flowNode) {
        if (Objects.isNull(midNodeList)) {
            midNodeList = new ArrayList<>();
        }
        midNodeList.add(flowNode);
    }

    /**
     * 添加结束节点
     * @param endFlowNode
     */
    public void addEndNode(EndFlowNode endFlowNode) {
        this.setEndNode(endFlowNode);
    }

}
