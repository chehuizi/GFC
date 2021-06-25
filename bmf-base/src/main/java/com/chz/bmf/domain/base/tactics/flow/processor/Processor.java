package com.chz.bmf.domain.base.tactics.flow.processor;

import com.chz.bmf.domain.base.tactics.flow.context.FlowContext;
import com.chz.bmf.domain.base.tactics.flow.context.FlowInputDataBase;
import com.chz.bmf.domain.base.tactics.flow.context.FlowOutputDataBase;

/**
 * 处理器
 */
public interface Processor {

    <R extends FlowInputDataBase, T extends FlowOutputDataBase, S> S process(FlowContext<R, T> flowContext);

}
