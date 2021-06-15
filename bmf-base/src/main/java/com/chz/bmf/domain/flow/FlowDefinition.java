package com.chz.bmf.domain.flow;

import com.chz.bmf.domain.flow.node.EndNode;
import com.chz.bmf.domain.flow.node.MiddleNode;
import com.chz.bmf.domain.flow.node.StartNode;
import lombok.Data;

import java.util.List;

/**
 * 流程定义
 */
@Data
public class FlowDefinition {

    /**
     * 开始节点
     */
    private StartNode startNode;
    /**
     * 结束节点
     */
    private EndNode endNode;
    /**
     * 中间节点列表
     */
    private List<MiddleNode> middleNodeList;


}
