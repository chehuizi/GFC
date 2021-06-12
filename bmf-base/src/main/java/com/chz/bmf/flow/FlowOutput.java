package com.chz.bmf.flow;

import com.chz.bmf.service.ServiceRespDataBase;
import lombok.Data;

/**
 * 业务领域服务流程输出
 * @param <T>
 */
@Data
public class FlowOutput<T extends ServiceRespDataBase> {

    /**
     * 服务结果
     */
    private boolean result;
    /**
     * 服务描述
     */
    private String  msg;
    /**
     * 服务响应数据
     */
    private T data;
}
