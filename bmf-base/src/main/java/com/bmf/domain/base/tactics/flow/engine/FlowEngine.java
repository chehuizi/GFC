package com.bmf.domain.base.tactics.flow.engine;

import com.bmf.domain.base.tactics.flow.context.FlowInput;
import com.bmf.domain.base.tactics.flow.context.FlowInputDataBase;
import com.bmf.domain.base.tactics.flow.context.FlowOutput;
import com.bmf.domain.base.tactics.flow.context.FlowOutputDataBase;

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
