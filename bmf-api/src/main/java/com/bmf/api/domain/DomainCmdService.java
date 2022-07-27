package com.bmf.api.domain;

import com.bmf.api.CmdService;
import com.bmf.api.Result;

/**
 * 业务域cmd服务
 */
public interface DomainCmdService extends CmdService<DomainReqDTO> {

    Result<Boolean> addEntity(DomainReqDTO domainReqDTO);
}
