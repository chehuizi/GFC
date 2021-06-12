package com.chz.bmf.base.flow;

/**
 * 业务领域服务流程
 */
public interface BusinessFlow4Service {

    /**
     * 流程触发
     * @param flowInput
     * @param <T>
     * @param <R>
     * @return
     */
    <T extends FlowOutputDataBase, R extends FlowInputDataBase> FlowOutput<T> trigger(FlowInput<R> flowInput);
}
