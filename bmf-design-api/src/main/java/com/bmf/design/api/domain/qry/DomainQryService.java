package com.bmf.design.api.domain.qry;

import com.bmf.common.api.QryService;
import com.bmf.common.api.Result;
import com.bmf.design.api.domain.dto.DomainQryReqDTO;
import com.bmf.design.api.domain.dto.DomainRespDTO;

/**
 * 业务域qry服务
 */
public interface DomainQryService extends QryService<DomainQryReqDTO, DomainRespDTO> {

    /**
     * 按业务查询领域
     * @param domainQryReqDTO
     * @return
     */
    Result<DomainRespDTO> queryByBusiness(DomainQryReqDTO domainQryReqDTO);
}
