package com.bmf.design.infrastructure.dal.po;

import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.design.base.enums.DomainElementEnum;
import lombok.Data;

import java.util.List;


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
