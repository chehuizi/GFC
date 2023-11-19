package com.bmf.design.api.domain.cmd;

import com.bmf.common.api.CmdService;
import com.bmf.common.api.Result;
import com.bmf.design.api.domain.dto.DomainValueObjectReqDTO;

/**
 * 领域值对象CMD服务
 */
public interface DomainValueObjectCmdService extends CmdService<DomainValueObjectReqDTO> {

    /**
     * 添加值对象属性
     * @param domainValueObjectReqDTO
     * @return
     */
    Result<Boolean> addValueObjectAttr(DomainValueObjectReqDTO domainValueObjectReqDTO);

    /**
     * 删除值对象属性
     * @param domainValueObjectReqDTO
     * @return
     */
    Result<Boolean> delValueObjectAttr(DomainValueObjectReqDTO domainValueObjectReqDTO);
}
