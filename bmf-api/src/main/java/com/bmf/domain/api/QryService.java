package com.bmf.domain.api;

/**
 * qry服务
 * @param <T>
 * @param <R>
 */
public abstract class QryService<T extends ReqDTO, R extends RespDTO> {

    /**
     * 查询单个
     * @param req
     * @return
     */
    public abstract Result<R> queryOne(T req);

}
