package com.bmf.api.domain.cmd;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainEntityReqDTO;

/**
 * 领域实体CMD服务
 */
public interface DomainEntityCmdService extends CmdService<DomainEntityReqDTO> {

    /**
     * 添加实体属性
     * @param domainEntityReqDTO
     * @return
     */
    Result<Boolean> addEntityAttr(DomainEntityReqDTO domainEntityReqDTO);

    /**
     * 删除实体属性
     * @param domainEntityReqDTO
     * @return
     */
    Result<Boolean> delEntityAttr(DomainEntityReqDTO domainEntityReqDTO);
}
