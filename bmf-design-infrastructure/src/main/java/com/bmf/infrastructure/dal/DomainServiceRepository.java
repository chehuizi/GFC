package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.service.DomainService;

import java.util.List;

public interface DomainServiceRepository extends BaseRepository<DomainService> {

    /**
     * 根据领域编码查询服务列表
     * @param domainCode
     * @return
     */
    List<DomainService> selectByDomainCode(Integer domainCode);
}