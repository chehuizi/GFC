package com.bmf.api.business;

import com.bmf.api.CmdService;
import com.bmf.api.Result;

/**
 * 业务cmd服务
 */
public interface BusinessCmdService extends CmdService<BusinessReqDTO> {

    /**
     * 添加领域
     * @param businessReqDTO
     * @return
     */
    Result<Boolean> addDomain(BusinessReqDTO businessReqDTO);

    /**
     * 添加领域关系
     * @param businessReqDTO
     * @return
     */
    Result<Boolean> addDomainRelation(BusinessReqDTO businessReqDTO);
}
