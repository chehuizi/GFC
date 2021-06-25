package com.chz.bmf.domain.base.tactics.flow.context;

import lombok.Data;

/**
 * 业务领域服务流程输入
 * @param <T>
 */
@Data
public class FlowInput<T extends FlowInputDataBase> {

    /**
     * 流程唯一标识
     */
    private String flowId;
    /**
     * 服务流程输入
     */
    private T data;
}
