package com.chz.bmf.domain.base.flow.engine;

import com.chz.bmf.domain.base.flow.context.FlowInput;
import com.chz.bmf.domain.base.flow.context.FlowInputDataBase;
import com.chz.bmf.domain.base.flow.context.FlowOutput;
import com.chz.bmf.domain.base.flow.context.FlowOutputDataBase;

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
