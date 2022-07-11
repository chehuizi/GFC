package com.bmf.infrastructure.dal;

import com.bmf.base.BaseDO;
import com.bmf.infrastructure.dal.po.BasePO;

/**
 * 仓储接口基类
 */
public interface BaseRepository<T extends BaseDO, R extends BasePO> {

    /**
     * 查询单条记录
     * @param req
     * @return
     */
     R selectOne(T req);

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
