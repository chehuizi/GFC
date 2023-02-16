package com.bmf.api.domain;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainServiceReqDTO;

/**
 * 领域服务CMD服务
 */
public interface DomainServiceCmdService extends CmdService<DomainServiceReqDTO> {

    /**
     * 添加服务属性
     * @param domainServiceReqDTO
     * @return
     */
    Result<Boolean> addServiceAttr(DomainServiceReqDTO domainServiceReqDTO);

    /**
     * 删除服务属性
     * @param domainServiceReqDTO
     * @return
     */
    Result<Boolean> delServiceAttr(DomainServiceReqDTO domainServiceReqDTO);
}
