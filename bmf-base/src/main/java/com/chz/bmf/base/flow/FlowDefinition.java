package com.chz.bmf.base.flow;

import com.chz.bmf.base.flow.node.PhaseNode;
import com.chz.bmf.base.flow.node.StartNode;
import lombok.Data;

import java.util.List;

/**
 * 流程定义
 */
@Data
public class FlowDefinition {

    private StartNode startNode;

    private List<PhaseNode> phaseNodeList;


}
