package com.bmf.api.domain.cmd;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainServiceCmdReqDTO;

/**
 * 领域服务CMD服务
 */
public interface DomainServiceCmdService extends CmdService<DomainServiceCmdReqDTO> {

    /**
     * 添加服务属性
     * @param domainServiceCmdReqDTO
     * @return
     */
    Result<Boolean> addServiceAttr(DomainServiceCmdReqDTO domainServiceCmdReqDTO);

    /**
     * 删除服务属性
     * @param domainServiceCmdReqDTO
     * @return
     */
    Result<Boolean> delServiceAttr(DomainServiceCmdReqDTO domainServiceCmdReqDTO);
}
