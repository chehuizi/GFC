package com.bmf.design.api.domain.cmd;

import com.bmf.design.api.CmdService;
import com.bmf.design.api.Result;
import com.bmf.design.api.domain.dto.DomainEventCmdReqDTO;

/**
 * 领域事件CMD服务
 */
public interface DomainEventCmdService extends CmdService<DomainEventCmdReqDTO> {

    /**
     * 添加事件属性
     * @param domainEventCmdReqDTO
     * @return
     */
    Result<Boolean> addEventAttr(DomainEventCmdReqDTO domainEventCmdReqDTO);

    /**
     * 删除事件属性
     * @param domainEventCmdReqDTO
     * @return
     */
    Result<Boolean> delEventAttr(DomainEventCmdReqDTO domainEventCmdReqDTO);
}
