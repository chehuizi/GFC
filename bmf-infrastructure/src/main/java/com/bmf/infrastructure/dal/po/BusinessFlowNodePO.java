package com.bmf.infrastructure.dal.po;

import lombok.Data;


@Data
public class BusinessFlowNodePO extends BasePO {

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
     * 前节点ID列表
     */
    private Integer[] preNodes;
    /**
     * 角色ID
     */
    private Integer roleId;
}
