package com.bmf.infrastructure.dal;

import com.bmf.base.application.DomainApi;

import java.util.List;

public interface DomainApiRepository extends BaseRepository<DomainApi> {

    /**
     * 批量插入
     * @param req
     * @return
     */
    boolean batchInsert(List<DomainApi> req);

    /**
     * 根据领域编码查询API
     * @param domainCode
     * @return
     */
    List<DomainApi> selectByDomainCode(Integer domainCode);
}
