package com.bmf.api.business;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.business.dto.BusinessCmdReqDTO;

/**
 * 业务cmd服务
 */
public interface BusinessCmdService extends CmdService<BusinessCmdReqDTO> {

    /**
     * 保存战略设计
     * @param businessCmdReqDTO
     * @return
     */
    Result<Boolean> saveStrategyDesign(BusinessCmdReqDTO businessCmdReqDTO);

    /**
     * 添加领域
     * @param businessCmdReqDTO
     * @return
     */
    Result<Boolean> addDomain(BusinessCmdReqDTO businessCmdReqDTO);

    /**
     * 删除领域
     * @param businessCmdReqDTO
     * @return
     */
    Result<Boolean> delDomain(BusinessCmdReqDTO businessCmdReqDTO);

    /**
     * 构建领域关系
     * @param businessCmdReqDTO
     * @return
     */
    Result<Boolean> buildDomainRelation(BusinessCmdReqDTO businessCmdReqDTO);

    /**
     * 移除领域关系
     * @param businessCmdReqDTO
     * @return
     */
    Result<Boolean> removeDomainRelation(BusinessCmdReqDTO businessCmdReqDTO);

    /**
     * 添加角色
     * @param businessCmdReqDTO
     * @return
     */
    Result<Boolean> addRole(BusinessCmdReqDTO businessCmdReqDTO);

    /**
     * 删除角色
     * @param businessCmdReqDTO
     * @return
     */
    Result<Boolean> delRole(BusinessCmdReqDTO businessCmdReqDTO);
}
