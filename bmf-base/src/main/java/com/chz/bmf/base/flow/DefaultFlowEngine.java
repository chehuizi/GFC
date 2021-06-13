package com.chz.bmf.base.flow;


import lombok.Data;

@Data
public class DefaultFlowEngine implements FlowEngine {

    @Override
    public <T extends FlowOutputDataBase, R extends FlowInputDataBase> FlowOutput<T> trigger(FlowInput<R> flowInput) {
        return null;
    }
}
