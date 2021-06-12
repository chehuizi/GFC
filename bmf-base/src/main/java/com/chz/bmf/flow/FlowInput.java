package com.chz.bmf.flow;

import com.chz.bmf.service.ServiceReqDataBase;
import lombok.Data;

/**
 * 业务领域服务流程请求参数
 * @param <T>
 */
@Data
public class FlowInput<T extends ServiceReqDataBase> {

    /**
     * 服务流程请求数据
     */
    private T data;
}
