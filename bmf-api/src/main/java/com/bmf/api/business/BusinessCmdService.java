package com.bmf.api.business;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.business.dto.BusinessReqDTO;

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
     * 删除领域
     * @param businessReqDTO
     * @return
     */
    Result<Boolean> delDomain(BusinessReqDTO businessReqDTO);

    /**
     * 构建领域关系
     * @param businessReqDTO
     * @return
     */
    Result<Boolean> buildDomainRelation(BusinessReqDTO businessReqDTO);

    /**
     * 移除领域关系
     * @param businessReqDTO
     * @return
     */
    Result<Boolean> removeDomainRelation(BusinessReqDTO businessReqDTO);
}
