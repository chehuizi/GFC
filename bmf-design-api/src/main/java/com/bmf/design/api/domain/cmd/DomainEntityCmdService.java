package com.bmf.design.api.domain.cmd;

import com.bmf.common.api.CmdService;
import com.bmf.common.api.Result;
import com.bmf.design.api.domain.dto.DomainEntityCmdReqDTO;

/**
 * 领域实体CMD服务
 */
public interface DomainEntityCmdService extends CmdService<DomainEntityCmdReqDTO> {

    /**
     * 添加实体属性
     * @param domainEntityCmdReqDTO
     * @return
     */
    Result<Boolean> addEntityAttr(DomainEntityCmdReqDTO domainEntityCmdReqDTO);

    /**
     * 删除实体属性
     * @param domainEntityCmdReqDTO
     * @return
     */
    Result<Boolean> delEntityAttr(DomainEntityCmdReqDTO domainEntityCmdReqDTO);
}
