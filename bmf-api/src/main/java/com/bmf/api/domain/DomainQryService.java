package com.bmf.api.domain;

import com.bmf.api.QryService;
import com.bmf.api.Result;

/**
 * 业务域cmd服务
 */
public interface DomainQryService extends QryService<DomainReqDTO, DomainRespDTO> {

    /**
     * 按业务查询领域
     * @param domainReqDTO
     * @return
     */
    Result<DomainRespDTO> queryByBusiness(DomainReqDTO domainReqDTO);
}
