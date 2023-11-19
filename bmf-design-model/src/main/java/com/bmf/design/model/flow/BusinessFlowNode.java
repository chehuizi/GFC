package com.bmf.design.model.flow;

import com.bmf.common.model.BaseModel;
import com.bmf.design.model.enums.BusinessFlowNodeTypeEnum;
import lombok.Builder;
import lombok.Data;

/**
 * 业务流程节点
 */
@Builder
@Data
public class BusinessFlowNode extends BaseModel {

    /**
     * 流程ID
     */
    private Integer flowId;
    /**
     * 节点ID
     */
    private Integer nodeId;
    /**
     * 节点名称（中文）
     */
    private String nodeName;
    /**
     * 节点别名（英文）
     */
    private String nodeAlias;
    /**
     * 节点类型
     * @see BusinessFlowNodeTypeEnum
     */
    private String nodeType;
    /**
     * 前置节点
     */
    private Integer[] preNodes;
    /**
     * 后置节点
     */
    private Integer[] nextNodes;
    /**
     * 节点执行条件
     */
    private String nodeCondition;
    /**
     * 节点内容
     */
    private String nodeContent;
}
