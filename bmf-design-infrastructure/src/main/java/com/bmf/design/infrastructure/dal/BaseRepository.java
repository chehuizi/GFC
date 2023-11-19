package com.bmf.design.infrastructure.dal;

import com.bmf.common.model.BaseModel;

/**
 * 仓储接口基类
 */
public interface BaseRepository<T extends BaseModel> {

    /**
     * 查询单条记录
     * @param req
     * @return
     */
     T selectOne(T req);

    /**
     * 插入
     * @param req
     * @return
     */
    boolean insert(T req);

    /**
     * 更新
     * @param req
     * @return
     */
    boolean update(T req);

    /**
     * 删除
     * @param req
     * @return
     */
    boolean delete(T req);
}
