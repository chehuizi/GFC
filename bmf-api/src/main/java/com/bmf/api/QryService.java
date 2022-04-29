package com.bmf.api;

/**
 * qry服务
 * @param <T>
 * @param <R>
 */
public interface QryService<T extends ReqDTO, R extends RespDTO> {

    /**
     * 查询单个
     * @param req
     * @return
     */
    Result<R> queryOne(T req);

}
