package com.bmf.infrastructure.dal;

import com.bmf.base.application.DomainApi;

import java.util.List;

public interface BusinessApiRepository extends BaseRepository<DomainApi> {

    /**
     * 批量插入
     * @param req
     * @return
     */
    boolean batchInsert(List<DomainApi> req);
}
