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
     * @see com.bmf.base.enums.BusinessFlowNodeTypeEnum
     */
    private String nodeType;
    /**
     * 领域元素
     * @see com.bmf.base.enums.DomainElementEnum
     */
    private String domainElement;
    /**
     * 领域元素ID
     */
    private Integer elementId;
    /**
     * 后节点ID列表
     */
    private Integer[] nextNodes;
}
