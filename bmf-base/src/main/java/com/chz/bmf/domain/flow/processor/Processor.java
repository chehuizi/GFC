package com.chz.bmf.domain.flow.processor;

import com.chz.bmf.domain.flow.FlowContext;
import com.chz.bmf.domain.flow.FlowInputDataBase;
import com.chz.bmf.domain.flow.FlowOutputDataBase;

/**
 * 处理器
 */
public interface Processor {

    <R extends FlowInputDataBase, T extends FlowOutputDataBase, S> S process(FlowContext<R, T> flowContext);

}
