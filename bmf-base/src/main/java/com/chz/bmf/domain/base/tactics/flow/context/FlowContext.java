package com.chz.bmf.domain.base.tactics.flow.context;

import lombok.Data;

/**
 * 服务流程上下文
 */
@Data
public class FlowContext<R extends FlowInputDataBase, T extends FlowOutputDataBase> {

    /**
     * 流程名称
     */
    private String flowName;
    /**
     * 输入
     */
    private R inputData;
    /**
     * 输出
     */
    private T outputData;

}
