package com.bmf.design.base.flow;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * 业务流程节点
 */
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
    private List<Integer> preNodes;
    /**
     * 后置节点
     */
    private List<Integer> nextNodes;
    /**
     * 节点执行条件
     */
    private String condition;
    /**
     * 节点内容
     */
    private String nodeContent;
}
