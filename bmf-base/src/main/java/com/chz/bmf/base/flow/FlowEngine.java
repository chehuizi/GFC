package com.chz.bmf.base.flow;

/**
 * 流程引擎
 */
public interface FlowEngine {

    /**
     * 流程触发
     * @param flowInput
     * @param <T>
     * @param <R>
     * @return
     */
    <T extends FlowOutputDataBase, R extends FlowInputDataBase> FlowOutput<T> trigger(FlowInput<R> flowInput);
}
