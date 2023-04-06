package com.bmf.base.flow;

import com.bmf.base.BaseModel;
import lombok.Data;

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
     * 节点名称
     */
    private String nodeName;
    /**
     * 节点
     */
    private String nodeType;
    /**
     * 领域元素
     */
    private String domainElement;
    /**
     * 领域元素ID
     */
    private Integer elementId;
    /**
     * 领域元素名称（中文）
     */
    private String elementName;
    /**
     * 领域元素别名（英文）
     */
    private String elementAlias;
    /**
     * 前节点ID
     */
    private String preNodeId;
}
