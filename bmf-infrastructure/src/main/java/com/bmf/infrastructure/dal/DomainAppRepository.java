package com.bmf.infrastructure.dal;

import com.bmf.base.application.DomainApp;

public interface DomainAppRepository extends BaseRepository<DomainApp> {

    /**
     * 根据领域编码查询APP
     *
     * @param domainCode
     * @return
     */
    DomainApp selectByDomainCode(Integer domainCode);

}
