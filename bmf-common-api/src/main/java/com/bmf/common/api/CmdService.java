package com.bmf.common.api;

/**
 * cmd服务
 * @param <T>
 */
public interface CmdService<T extends ReqDTO> {

    /**
     * 增加
     * @param req
     * @return
     */
    Result<Boolean> create(T req);

    /**
     * 更新
     * @param req
     * @return
     */
    Result<Boolean> update(T req);

    /**
     * 删除
     * @param req
     * @return
     */
    Result<Boolean> delete(T req);

}
