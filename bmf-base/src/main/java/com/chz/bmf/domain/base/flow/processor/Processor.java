package com.chz.bmf.domain.base.flow.processor;

import com.chz.bmf.domain.base.flow.context.FlowContext;
import com.chz.bmf.domain.base.flow.context.FlowInputDataBase;
import com.chz.bmf.domain.base.flow.context.FlowOutputDataBase;

/**
 * 处理器
 */
public interface Processor {

    <R extends FlowInputDataBase, T extends FlowOutputDataBase, S> S process(FlowContext<R, T> flowContext);

}
