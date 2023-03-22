package com.bmf.api.domain.cmd;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainCmdReqDTO;

/**
 * 业务领域cmd服务
 */
public interface DomainCmdService extends CmdService<DomainCmdReqDTO> {

    /**
     * 添加领域实体
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> addEntity(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 删除领域实体
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> delEntity(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 添加领域服务
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> addService(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 删除领域服务
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> delService(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 添加领域值对象
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> addValueObject(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 删除领域值对象
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> delValueObject(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 添加领域事件
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> addEvent(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 删除领域事件
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> delEvent(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 添加领域实体和值对象关系
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> addEntityRelVO(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 删除领域实体和值对象关系
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> delEntityRelVO(DomainCmdReqDTO domainCmdReqDTO);

    /**
     * 添加聚合根
     * @param domainCmdReqDTO
     * @return
     */
    Result<Boolean> addAggregate(DomainCmdReqDTO domainCmdReqDTO);

}
