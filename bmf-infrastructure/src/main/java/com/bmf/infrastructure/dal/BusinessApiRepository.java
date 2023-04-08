package com.bmf.infrastructure.dal;

import com.bmf.base.application.BusinessApi;

import java.util.List;

public interface BusinessApiRepository extends BaseRepository<BusinessApi> {

    /**
     * 批量插入
     * @param req
     * @return
     */
    boolean batchInsert(List<BusinessApi> req);
}
