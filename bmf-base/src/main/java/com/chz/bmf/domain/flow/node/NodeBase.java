package com.chz.bmf.domain.flow.node;

import com.chz.bmf.domain.flow.FlowContext;
import com.chz.bmf.domain.flow.FlowInputDataBase;
import com.chz.bmf.domain.flow.FlowOutputDataBase;
import com.chz.bmf.domain.flow.processor.Processor;
import lombok.Data;

/**
 * 节点基类
 */
@Data
public class NodeBase {

    /**
     * 节点名称
     */
    private String name;
    /**
     * 原子能力
     */
    private Processor processor;

    public <T> T output() {
        FlowContext<FlowInputDataBase, FlowOutputDataBase> flowContext = new FlowContext<>();
        return processor.process(flowContext);
    }

}
