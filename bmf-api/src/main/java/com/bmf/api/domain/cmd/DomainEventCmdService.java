package com.bmf.api.domain.cmd;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainEventReqDTO;

/**
 * 领域事件CMD服务
 */
public interface DomainEventCmdService extends CmdService<DomainEventReqDTO> {

    /**
     * 添加事件属性
     * @param domainEventReqDTO
     * @return
     */
    Result<Boolean> addEventAttr(DomainEventReqDTO domainEventReqDTO);

    /**
     * 删除事件属性
     * @param domainEventReqDTO
     * @return
     */
    Result<Boolean> delEventAttr(DomainEventReqDTO domainEventReqDTO);
}
