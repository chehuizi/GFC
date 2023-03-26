package com.bmf.api.domain.cmd;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainValueObjectReqDTO;

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
