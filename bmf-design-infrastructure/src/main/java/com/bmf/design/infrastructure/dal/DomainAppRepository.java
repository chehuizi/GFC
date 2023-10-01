package com.bmf.design.infrastructure.dal;

import com.bmf.design.base.application.DomainApp;

public interface DomainAppRepository extends BaseRepository<DomainApp> {

    /**
     * 根据领域编码查询APP
     *
     * @param domainCode
     * @return
     */
    DomainApp selectByDomainCode(Integer domainCode);

}
