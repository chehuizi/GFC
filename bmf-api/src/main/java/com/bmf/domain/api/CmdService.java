package com.bmf.domain.api;

/**
 * cmd服务
 * @param <T>
 */
public abstract class CmdService<T extends ReqDTO, R extends RespDTO> {

    /**
     * 增加
     * @param req
     * @return
     */
    public abstract Result<R> create(T req);

    /**
     * 更新
     * @param req
     * @return
     */
    public abstract Result<R> update(T req);

    /**
     * 删除
     * @param req
     * @return
     */
    public abstract Result<R> delete(T req);

}
