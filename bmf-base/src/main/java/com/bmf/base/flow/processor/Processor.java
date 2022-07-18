package com.bmf.base.flow.processor;

import com.bmf.base.flow.context.FlowContext;
import com.bmf.base.flow.context.FlowInputDataBase;
import com.bmf.base.flow.context.FlowOutputDataBase;

/**
 * 处理器
 */
public interface Processor {

    <R extends FlowInputDataBase, T extends FlowOutputDataBase, S> S process(FlowContext<R, T> flowContext);

}
