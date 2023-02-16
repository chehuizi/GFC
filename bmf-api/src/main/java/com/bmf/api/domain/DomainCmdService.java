package com.bmf.api.domain;

import com.bmf.api.CmdService;
import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainReqDTO;

/**
 * 业务领域cmd服务
 */
public interface DomainCmdService extends CmdService<DomainReqDTO> {

    /**
     * 添加领域实体
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addEntity(DomainReqDTO domainReqDTO);

    /**
     * 删除领域实体
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> delEntity(DomainReqDTO domainReqDTO);

    /**
     * 添加领域服务
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addService(DomainReqDTO domainReqDTO);

    /**
     * 删除领域服务
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> delService(DomainReqDTO domainReqDTO);

    /**
     * 添加领域事件
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addDomainEvent(DomainReqDTO domainReqDTO);

    /**
     * 添加领域值对象
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addValueObject(DomainReqDTO domainReqDTO);

    /**
     * 领域实体添加值对象
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addEntityRelVO(DomainReqDTO domainReqDTO);

    /**
     * 添加聚合根
     * @param domainReqDTO
     * @return
     */
    Result<Boolean> addAggregate(DomainReqDTO domainReqDTO);

}
