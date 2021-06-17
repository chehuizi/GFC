package com.chz.bmf.domain.base.service;

import lombok.Data;

/**
 * 业务领域服务请求参数
 * @param <T>
 */
@Data
public class ServiceReq<T extends ServiceReqDataBase> {

    /**
     * 服务请求数据
     */
    private T data;
}
