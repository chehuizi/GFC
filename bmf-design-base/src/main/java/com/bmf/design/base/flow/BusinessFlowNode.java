package com.bmf.design.base.flow;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.design.base.enums.DomainElementEnum;
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
     * 节点名称（中文）
     */
    private String nodeName;
    /**
     * 节点别名（英文）
     */
    private String nodeAlias;
    /**
     * 节点
     * @see BusinessFlowNodeTypeEnum
     */
    private String nodeType;
    /**
     * 领域元素
     * @see DomainElementEnum
     */
    private String domainElement;
    /**
     * 领域元素ID
     */
    private Integer elementId;
    /**
     * 前节点ID列表
     */
    private Integer[] preNodes;
    /**
     * 角色ID
     */
    private Integer roleId;
}
