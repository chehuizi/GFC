package com.bmf.infrastructure.dal;

import com.bmf.base.application.DomainAppApi;

import java.util.List;

public interface DomainAppApiRepository extends BaseRepository<DomainAppApi> {

    /**
     * 批量插入
     * @param req
     * @return
     */
    boolean batchInsert(List<DomainAppApi> req);

    /**
     * 根据领域编码查询API
     * @param domainCode
     * @return
     */
    List<DomainAppApi> selectByDomainCode(Integer domainCode);
}
