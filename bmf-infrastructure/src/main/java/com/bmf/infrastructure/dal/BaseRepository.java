package com.bmf.infrastructure.dal;

import com.bmf.api.ReqDTO;
import com.bmf.infrastructure.dal.po.BasePO;

/**
 * 仓储接口基类
 */
public interface BaseRepository {

    /**
     * 查询单条记录
     * @param req
     * @param <T>
     * @param <R>
     * @return
     */
    <T extends ReqDTO, R extends BasePO> R selectOne(T req);

    /**
     * 插入
     * @param req
     * @param <T>
     * @return
     */
    <T extends ReqDTO> boolean insert(T req);

    /**
     * 更新
     * @param req
     * @param <T>
     * @return
     */
    <T extends ReqDTO> boolean update(T req);

    /**
     * 删除
     * @param req
     * @param <T>
     * @return
     */
    <T extends ReqDTO> boolean delete(T req);
}
