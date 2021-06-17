package com.chz.bmf.domain.base.service;

import lombok.Data;

/**
 * 业务领域服务响应结果
 * @param <T>
 */
@Data
public class ServiceResp<T extends ServiceRespDataBase> {

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
