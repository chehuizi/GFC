package com.bmf.api.business;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.DomainReqDTO;

/**
 * 业务cmd服务
 */
public interface BusinessCmdService extends CmdService<BusinessReqDTO, BusinessRespDTO> {

    /**
     * 添加领域
     * @param businessReqDTO
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addDomain(BusinessReqDTO businessReqDTO, DomainReqDTO domainReqDTO);

}
