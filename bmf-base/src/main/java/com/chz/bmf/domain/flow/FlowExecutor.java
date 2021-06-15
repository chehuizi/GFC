package com.chz.bmf.domain.flow;

import java.util.HashMap;
import java.util.Map;

public class FlowExecutor {

    // todo 流程定义初始化
    private Map<String, FlowDefinition> flowDefinitionMap = new HashMap<>();

    public <R extends FlowInputDataBase, T extends FlowOutputDataBase> void execute(FlowContext<R, T> flowContext) {
        FlowDefinition flowDefinition = flowDefinitionMap.get(flowContext.getFlowName());

    }

}
