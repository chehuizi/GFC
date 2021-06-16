package com.chz.bmf.domain.flow.engine;

import com.chz.bmf.domain.flow.context.FlowInputDataBase;
import com.chz.bmf.domain.flow.context.FlowOutputDataBase;
import com.chz.bmf.domain.flow.context.FlowContext;
import com.chz.bmf.domain.flow.definition.FlowDefinition;
import com.chz.bmf.domain.flow.line.Line;
import com.chz.bmf.domain.flow.node.EndNode;
import com.chz.bmf.domain.flow.node.NodeBase;
import com.chz.bmf.domain.flow.node.StartNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowExecutor {

    // todo 流程定义初始化
    private Map<String, FlowDefinition> flowDefinitionMap = new HashMap<>();

    public <R extends FlowInputDataBase, T extends FlowOutputDataBase> void execute(FlowContext<R, T> flowContext) {
        FlowDefinition flowDefinition = flowDefinitionMap.get(flowContext.getFlowName());
        StartNode startNode = flowDefinition.getStartNode();
        executeNode(flowContext, flowDefinition, startNode);
    }

    /**
     * 执行节点原子能力
     * @param flowContext
     * @param flowDefinition
     * @param node
     * @param <R>
     * @param <T>
     */
    private <R extends FlowInputDataBase, T extends FlowOutputDataBase> void executeNode(FlowContext<R, T> flowContext, FlowDefinition flowDefinition, NodeBase node) {
        if (node instanceof EndNode) {
            return;
        }

        List<Line> lines = flowDefinition.getLineMap().get(node.getName());
        for (Line line : lines) {
            if (line.isMatchCondition(node.getProcessor().process(flowContext))) {
                executeNode(flowContext, flowDefinition, line.getTo());
            }
        }
    }

}
