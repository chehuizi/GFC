package com.bmf.base.tactics.service;

/**
 * 业务领域服务
 */
public interface BusinessService {

    /**
     * 服务触发
     * @param serviceReq
     * @param <R>
     * @param <T>
     * @return
     */
    <R extends ServiceReqDataBase, T extends ServiceRespDataBase> ServiceResp<T> invoke(ServiceReq<R> serviceReq);

}
